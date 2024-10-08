package com.banking.apps.banking_app.service;

import com.banking.apps.banking_app.dto.AccountDto;

import java.util.List;

public interface AccountService {
    //feature-1 add account rest api
    AccountDto createAccount(AccountDto accountDto);
    //feature-2 Get account rest api
    AccountDto getAccountById(Long id);
    //feature-3 Deposit account rest api
    AccountDto deposit(Long id, double amount);
    //feature-4 withdraw account rest api
    AccountDto withdraw(Long id, double amount);
    //feature-5 Get all account rest api
    List<AccountDto> getAllAccounts();
    //feature-6 Delete account rest api
    void deleteAccount(Long id);

}
