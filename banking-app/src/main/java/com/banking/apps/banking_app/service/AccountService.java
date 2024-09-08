package com.banking.apps.banking_app.service;

import com.banking.apps.banking_app.dto.AccountDto;

public interface AccountService {
    //feature-1 add account rest api
    AccountDto createAccount(AccountDto accountDto);

}
