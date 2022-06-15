package com.example.SOLIDBankApp.Account.Controllers;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Account.Accounts.AccountType;
import com.example.SOLIDBankApp.Account.Creation.BankCore;
import com.example.SOLIDBankApp.Account.Services.AccountDataService;
import com.example.SOLIDBankApp.Exceptions.*;
import com.example.SOLIDBankApp.Transactions.Deposit.TransactionDeposit;
import com.example.SOLIDBankApp.Transactions.Service.TransactionDataService;
import com.example.SOLIDBankApp.Transactions.Transaction;
import com.example.SOLIDBankApp.Transactions.Withdraw.TransactionWithdraw;
import com.example.SOLIDBankApp.Users.JwtFilter;
import com.example.SOLIDBankApp.Users.JwtProvider;
import com.example.SOLIDBankApp.Users.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@SecurityRequirement(name = "basicauth")
@AllArgsConstructor
public class AccountController {

    private final JwtProvider jwtProvider;
    private final UserService userService;
    private final JwtFilter jwtFilter;
    private final AccountDataService accountDataService;
    private final TransactionWithdraw transactionWithdraw;
    private final TransactionDeposit transactionDeposit;
    private final TransactionDataService transactionDataService;
    private final BankCore bankCore;

    private String getClientID(String request){
        System.out.println(request);
        return jwtProvider.getIDFromToken(request.substring(7));
    }
    @GetMapping
    public List<Account> getAccounts(@RequestHeader("Authorization") String request){
        return accountDataService.getClientAccounts(getClientID(request));
    }
    @PostMapping
    public void createAccount(@RequestParam AccountType accountType,@RequestHeader("Authorization") String request){
        bankCore.createNewAccount(accountType, getClientID(request));
    }

    @GetMapping("/{account_id}")
    public Account getAccount(@PathVariable String account_id, @RequestHeader("Authorization") String request)    {
        try {
            return accountDataService.getClientAccount(getClientID(request), account_id);
        } catch (AccountNotFound e) {
            throw new RuntimeException(e);
        }
    }
    @DeleteMapping("/{account_id}")
    public void deleteAccount(@PathVariable String account_id, @RequestHeader("Authorization") String request){
        try {
            accountDataService.delete(getClientID(request), account_id);
            transactionDataService.delete(account_id);
        } catch (AccountNotFound | ClientNotFound e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/{account_id}/withdraw")
    public void withdraw(@PathVariable String account_id, @RequestParam double amount, @RequestHeader("Authorization") String request){
        try {
            transactionWithdraw.execute(accountDataService.getClientWithdrawAccount(getClientID(request), account_id), amount);
        } catch (NotEnoughMoney | NegativeAmount | AccountNotWithdraw | AccountNotFound e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/{account_id}/deposit")
    public void deposit(@PathVariable String account_id, @RequestParam double amount, @RequestHeader("Authorization") String request){
        try {
            transactionDeposit.execute(getAccount(account_id, request), amount);
        } catch (NegativeAmount e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/{account_id}/transactions")
    public List<Transaction> getTransactions(@PathVariable String account_id, @RequestHeader("Authorization") String request){
        try{
            accountDataService.getClientAccount(getClientID(request), account_id);
        } catch (AccountNotFound e) {
            throw new RuntimeException(e);
        }
        return transactionDataService.getAccountTransactions(account_id);
    }
}
