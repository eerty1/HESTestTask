package com.hes.data_provider.command_service;

import com.hes.model.user.User;
import com.hes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.http.HttpStatus.CONFLICT;

@Service("userCommandService")
public class UserCommandService extends CommandService<User, Long> {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserCommandService(ListCrudRepository<User, Long> listCrudRepository, PasswordEncoder passwordEncoder) {
        super(listCrudRepository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public ResponseEntity<String> save(User user) {
        if (!((UserRepository) listCrudRepository).existsByUsername(user.getUsername())) {
            super.save(user.toUser(passwordEncoder));
            return RESPONSE_SUCCESS;
        }
        return new ResponseEntity<>("User " + user.getUsername() + " already exists", CONFLICT);
    }
}
