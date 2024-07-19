package com.hes.web.user;

import com.hes.data_provider.query_service.UserQueryService;
import com.hes.model.account.Account;
import com.hes.model.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserQueryService userQueryService;

    @Operation(summary = "find a user by ID")
    @GetMapping(path = "/{id}")
    public User findById(@PathVariable Long id) {
        return userQueryService.findById(id);
    }

    @Operation(summary = "find a user by an account")
    @GetMapping(path = "/account")
    public User findByAccount(@RequestBody Account account) {
        return userQueryService.findUserByAccount(account);
    }
}
