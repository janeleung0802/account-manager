package com.acmebank.accountmanager.web.controller;

import com.acmebank.accountmanager.entity.Account;
import com.acmebank.accountmanager.entity.service.AccountService;
import com.acmebank.accountmanager.request.TransferRequest;
import com.acmebank.accountmanager.service.MoneyTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Validated
@RestController
public class AccountManagerWebApiController {

    @Autowired
    private MoneyTransferService moneyTransferService;

    @Autowired
    private AccountService accountService;

    @GetMapping(path = "/account/{id}")
    public ResponseEntity<Account> transfer(@PathVariable("id") @Pattern(regexp = "^\\d{8}$", message = "Invalid account id pattern.") String id) throws Exception {
        Account account = accountService.getById(id);
        return ResponseEntity.ok(account);
    }

    @PostMapping(path = "/transfer")
    public ResponseEntity<Account> transfer(@RequestBody @Valid TransferRequest transferRequest) throws Exception {
        Account account = moneyTransferService.transferMoney(transferRequest);
        return ResponseEntity.ok(account);
    }
}

