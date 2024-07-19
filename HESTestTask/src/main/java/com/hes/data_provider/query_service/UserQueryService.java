package com.hes.data_provider.query_service;


import com.hes.model.account.Account;
import com.hes.model.user.User;
import com.hes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userQueryService")
public class UserQueryService extends QueryService<User, Long> {

    @Autowired
    public UserQueryService(ListCrudRepository<User, Long> listCrudRepository) {
        super(listCrudRepository);
    }

    @Transactional
    public User findUserByAccount(Account account) {
        return ((UserRepository) listCrudRepository).findByAccount(account);
    }
}
