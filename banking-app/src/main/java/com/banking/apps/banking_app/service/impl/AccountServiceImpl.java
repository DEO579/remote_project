package com.banking.apps.banking_app.service.impl;

import com.banking.apps.banking_app.dto.AccountDto;
import com.banking.apps.banking_app.entity.Account;
import com.banking.apps.banking_app.mapper.AccountMapper;
import com.banking.apps.banking_app.repository.AccountRepository;
import com.banking.apps.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    //feature-3 Deposit account rest api implementation this method into service impl class
    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exist"));
        double total = account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
    //feature-4 withdraw account rest api implementation this method into service impl class
    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exist"));
     if (account.getBalance()<amount){
    throw new RuntimeException("insufficient amount");
        }

        double total = account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
   //feature-5 get all account rest api implementation this method into service impl class
    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(account -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }
   //feature-6 delete account rest api implementation this method into service impl class
    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exist"));
        accountRepository.deleteById(id);
    }
}
