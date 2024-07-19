package com.hes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ChangeAccountStatusDto {
    private UUID accountId;
    private String accountStatus;
}
