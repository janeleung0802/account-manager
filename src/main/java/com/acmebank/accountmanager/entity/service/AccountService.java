package com.acmebank.accountmanager.entity.service;


import com.acmebank.accountmanager.entity.Account;
import com.acmebank.accountmanager.exception.ResourceNotFoundException;
import com.acmebank.accountmanager.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getById(String id){
       return accountRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Account with id ["+id+"] not found."));
    }

    public Account update(Account account){
        return accountRepository.save(account);
    }
}
