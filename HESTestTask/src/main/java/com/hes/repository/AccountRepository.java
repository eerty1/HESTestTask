package com.hes.repository;

import com.hes.model.account.Account;
import com.hes.model.user.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends ListCrudRepository<Account, UUID> {
    Account findByUser(User user);
}
