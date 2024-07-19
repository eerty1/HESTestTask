package com.hes.web.user;

import com.hes.data_provider.command_service.AccountCommandService;
import com.hes.data_provider.query_service.AccountQueryService;
import com.hes.dto.ChangeAccountBalanceDto;
import com.hes.model.account.Account;
import com.hes.model.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountQueryService accountQueryService;
    private final AccountCommandService accountCommandService;

    @Operation(summary = "find an account by a user")
    @PostMapping(path = "/user")
    public Account findByUser(@RequestBody User user) {
        return accountQueryService.findByUser(user);
    }

    @Operation(summary = "refill balance")
    @PostMapping(path = "/refill")
    public ResponseEntity<String> refillBalance(@RequestBody ChangeAccountBalanceDto changeAccountBalanceDto) {
        return accountCommandService.refillBalance(changeAccountBalanceDto);
    }

    @Operation(summary = "withdraw money from balance")
    @PostMapping(path = "/withdrawal")
    public ResponseEntity<String> withDrawMoney(@RequestBody ChangeAccountBalanceDto changeAccountBalanceDto) {
        return accountCommandService.withdrawMoney(changeAccountBalanceDto);
    }
}
