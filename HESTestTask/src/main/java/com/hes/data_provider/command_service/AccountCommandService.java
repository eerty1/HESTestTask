package com.hes.data_provider.command_service;

import com.hes.dto.ChangeAccountBalanceDto;
import com.hes.dto.ChangeAccountStatusDto;
import com.hes.model.account.Account;
import com.hes.model.account.AccountStatus;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.Consumer;

import static com.hes.model.account.AccountStatus.ACTIVE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;


@Service("accountCommandService")
public class AccountCommandService extends CommandService<Account, UUID> {
    private static final ResponseEntity<String> ACCOUNT_BLOCKED_RESPONSE_ENTITY = new ResponseEntity<>("Your account is blocked", BAD_REQUEST);

    @Autowired
    public AccountCommandService(ListCrudRepository<Account, UUID> listCrudRepository) {
        super(listCrudRepository);
    }

    public void changeAccountStatus(ChangeAccountStatusDto changeAccountStatusDto) {
        Account account = listCrudRepository.findById(changeAccountStatusDto.getAccountId()).orElseThrow(EntityNotFoundException::new);
        account.setAccountStatus(AccountStatus.valueOf(changeAccountStatusDto.getAccountStatus()));
        super.update(account);
    }

    public ResponseEntity<String> refillBalance(ChangeAccountBalanceDto changeAccountBalanceDto) {
        Account account = listCrudRepository.findById(changeAccountBalanceDto.getAccountId()).orElseThrow(EntityNotFoundException::new);
        return performBalanceOperation(account, accountInstance -> accountInstance.setBalance(account.getBalance().add(changeAccountBalanceDto.getSum())));
    }

    public ResponseEntity<String> withdrawMoney(ChangeAccountBalanceDto changeAccountBalanceDto) {
        Account account = listCrudRepository.findById(changeAccountBalanceDto.getAccountId()).orElseThrow(EntityNotFoundException::new);

        BigDecimal moneyLeft = account.getBalance().subtract(changeAccountBalanceDto.getSum());
        if (moneyLeft.doubleValue() >= 0) {
            return performBalanceOperation(account, accountInstance -> accountInstance.setBalance(moneyLeft));
        }
        return new ResponseEntity<>("The requested sum is above your account balance", BAD_REQUEST);
    }

    private ResponseEntity<String> performBalanceOperation(Account account, Consumer<Account> balanceOperation) {
        if (isActive(account)) {
            balanceOperation.accept(account);
            super.update(account);
            return RESPONSE_SUCCESS;
        }
        return ACCOUNT_BLOCKED_RESPONSE_ENTITY;
    }

    private boolean isActive(Account account) {
        return account.getAccountStatus() == ACTIVE;
    }
}
