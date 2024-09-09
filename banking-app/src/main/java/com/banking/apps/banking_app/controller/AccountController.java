package com.banking.apps.banking_app.controller;

import com.banking.apps.banking_app.dto.AccountDto;
import com.banking.apps.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    //feature-1 add account rest api controller method
    @PostMapping
    //post method  url http://localhost:8080/api/accounts
   /* {
        "accountHolderName":"deo",
            "balance":10000.0
    }*/
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
   //feature-2 Get account rest api controller method
   @GetMapping("/{id}")
   //Get method  url http://localhost:8080/api/accounts/1
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
       AccountDto accountDto = accountService.getAccountById(id);
       return ResponseEntity.ok(accountDto);
    }
   //feature-3 Deposit account rest api controller method
    @PutMapping("/{id}/deposit")
    //PUT method  url http://localhost:8080/api/accounts/1/deposit
    //body raw {"amount" : 5000}
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
       Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }
   //feature-4 withdraw account rest api controller method
   @PutMapping("/{id}/withdraw")
   //PUT method  url http://localhost:8080/api/accounts/1/withdraw
   //body raw {"amount" : 5000}
   public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
       Double amount = request.get("amount");
       AccountDto accountDto = accountService.withdraw(id, amount);
       return ResponseEntity.ok(accountDto);
   }
   //feature-5 get all account rest api controller method
    @GetMapping
    //get method  url http://localhost:8080/api/accounts
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    //feature-6 delete account rest api controller method
    @DeleteMapping("/{id}")
    //DELETE method  url http://localhost:8080/api/accounts/1
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted successfully");
    }
}