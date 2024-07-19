package com.hes.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ChangeAccountBalanceDto {
    private UUID accountId;
    private BigDecimal sum;
}
