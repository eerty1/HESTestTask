package com.hes.security;

import com.hes.dto.LoginCredentialsDto;
import com.hes.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String login(LoginCredentialsDto loginCredentialsDto) throws BadCredentialsException {
        return jwtService.generateToken(
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginCredentialsDto.getUsername(),
                                loginCredentialsDto.getPassword()
                        )
                )
        );
    }
}