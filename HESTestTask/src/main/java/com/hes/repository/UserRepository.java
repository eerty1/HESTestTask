package com.hes.repository;

import com.hes.model.account.Account;
import com.hes.model.user.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

    User findByAccount(Account account);
}
