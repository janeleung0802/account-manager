package com.acmebank.accountmanager.service;


import com.acmebank.accountmanager.entity.Account;
import com.acmebank.accountmanager.entity.service.AccountService;
import com.acmebank.accountmanager.exception.ValidationFailedException;
import com.acmebank.accountmanager.request.TransferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional(rollbackFor = {Exception.class})
public class MoneyTransferService {

    @Autowired
    private AccountService accountService;

    private final Object lock = new Object();

    private void validate(Account fromAccount, Account toAccount, BigDecimal amount) {
        if (fromAccount.getBalance() == null || fromAccount.getBalance().compareTo(amount) < 0)
            throw new ValidationFailedException("Account with id [" + fromAccount.getId() + "] does not have sufficient balance");
        if (fromAccount.getId().equals(toAccount.getId()))
            throw new ValidationFailedException("From Account and To Account should not be the same.");
    }

    public Account transferMoney(TransferRequest transferRequest){
        synchronized (lock) {
            Account fromAccount = accountService.getById(transferRequest.getAccountFromId());
            Account toAccount = accountService.getById(transferRequest.getAccountToId());
            BigDecimal amount = transferRequest.getAmount();
            validate(fromAccount, toAccount, amount);
            fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
            fromAccount = accountService.update(fromAccount);
            toAccount.setBalance(toAccount.getBalance().add(amount));
            accountService.update(toAccount);
            return fromAccount;
        }
    }
}
