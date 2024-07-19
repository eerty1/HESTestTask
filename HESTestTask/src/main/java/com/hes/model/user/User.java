package com.hes.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hes.model.account.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_pool")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /*
        Here GenerationType.IDENTITY is used to make id generation compatible with data.sql file (SEQUENCE is not),
        that populates data on application startup.

        In real-world applications SEQUENCE strategy is preferred, but in this project it is omitted to avoid ids' conflicts.



        This is what SEQUENCE could look like

        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_seq"
        )
        @SequenceGenerator(
            name="product_seq",
            sequenceName="product_seq"
        )
    */

    private Long id;

    private String username;
    private String password;

    @Enumerated(value = STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(id, username, passwordEncoder.encode(password), role, account);
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}

