package com.banking.apps.banking_app.service.impl;

import com.banking.apps.banking_app.dto.AccountDto;
import com.banking.apps.banking_app.entity.Account;
import com.banking.apps.banking_app.mapper.AccountMapper;
import com.banking.apps.banking_app.repository.AccountRepository;
import com.banking.apps.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    //feature-1 add account rest api implementation method
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
    //feature-2 Get account rest api implementation this method into service impl class
    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }
}
