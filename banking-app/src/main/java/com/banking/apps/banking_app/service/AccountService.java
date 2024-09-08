package com.banking.apps.banking_app.service;

import com.banking.apps.banking_app.dto.AccountDto;

public interface AccountService {
    //feature-1 add account rest api
    AccountDto createAccount(AccountDto accountDto);
    //feature-2 Get account rest api
    AccountDto getAccountById(Long id);
    //feature-3 Deposit account rest api
    AccountDto deposit(Long id, double amount);
}
