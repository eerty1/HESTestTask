package com.hes.model.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hes.model.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(value = STRING)
    private AccountStatus accountStatus;
    private BigDecimal balance;

    @JsonIgnore
    @OneToOne(mappedBy = "account")
    private User user;
}
