package com.hes.web.admin;

import com.hes.data_provider.command_service.AccountCommandService;
import com.hes.data_provider.query_service.AccountQueryService;
import com.hes.dto.ChangeAccountStatusDto;
import com.hes.model.account.Account;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin/account")
@RequiredArgsConstructor
public class AccountAdminController {

    private final AccountQueryService accountQueryService;
    private final AccountCommandService accountCommandService;

    @Operation(summary = "find all accounts")
    @GetMapping
    public List<Account> findAllAccounts() {
        return accountQueryService.findAll();
    }

    @Operation(
            summary = "change account status",
            description = "permitted value for accountStatus: ACTIVE/BLOCKED"
    )
    @PostMapping(path = "/status")
    public void changeAccountStatus(@RequestBody ChangeAccountStatusDto changeAccountStatusDto) {
        accountCommandService.changeAccountStatus(changeAccountStatusDto);
    }
}
