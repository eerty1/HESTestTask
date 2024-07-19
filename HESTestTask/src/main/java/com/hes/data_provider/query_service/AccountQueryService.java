package com.hes.data_provider.query_service;

import com.hes.model.account.Account;
import com.hes.model.user.User;
import com.hes.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service("accountService")
public class AccountQueryService extends QueryService<Account, UUID> {

    @Autowired
    public AccountQueryService(ListCrudRepository<Account, UUID> listCrudRepository) {
        super(listCrudRepository);
    }

    @Transactional
    public Account findByUser(User user) {
        return ((AccountRepository) listCrudRepository).findByUser(user);
    }
}
