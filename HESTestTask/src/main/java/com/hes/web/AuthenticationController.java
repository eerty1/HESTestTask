package com.hes.web;

import com.hes.data_provider.command_service.UserCommandService;
import com.hes.dto.LoginCredentialsDto;
import com.hes.model.user.User;
import com.hes.security.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserCommandService userCommandService;
    private final LoginService loginService;

    @Operation(
            summary = "register a user",
            description = "permitted value for role: ADMIN/USER"
    )
    @PostMapping(path = "/registration")
    public ResponseEntity<String> register(@RequestBody User user) {
        return userCommandService.save(user);
    }

    @Operation(summary = "login as a user")
    @PostMapping(path = "/login")
    public String login(@RequestBody LoginCredentialsDto loginCredentialsDto) {
        return loginService.login(loginCredentialsDto);
    }
}
