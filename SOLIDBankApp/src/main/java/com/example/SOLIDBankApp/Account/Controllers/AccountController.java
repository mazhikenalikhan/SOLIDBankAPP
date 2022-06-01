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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("{clientID}/accounts")
public class AccountController {
    private final AccountDataService accountDataService;
    private final TransactionWithdraw transactionWithdraw;
    private final TransactionDeposit transactionDeposit;
    private final TransactionDataService transactionDataService;
    private final BankCore bankCore;

    public AccountController(AccountDataService accountDataService, TransactionWithdraw transactionWithdraw, TransactionDeposit transactionDeposit, TransactionDataService transactionDataService, BankCore bankCore) {
        this.accountDataService = accountDataService;
        this.transactionWithdraw = transactionWithdraw;
        this.transactionDeposit = transactionDeposit;
        this.transactionDataService = transactionDataService;
        this.bankCore = bankCore;
    }

    @GetMapping
    public List<Account> getAccounts(@PathVariable String clientID){
        return accountDataService.getClientAccounts(clientID);
    }

    @PostMapping
    public void createAccount(@RequestParam AccountType accountType, @PathVariable String clientID){
        bankCore.createNewAccount(accountType, clientID);
    }

    @GetMapping("/{account_id}")
    public Account getAccount(@PathVariable String clientID, @PathVariable String account_id)    {
        try {
            return accountDataService.getClientAccount(clientID, account_id);
        } catch (AccountNotFound e) {
            throw new RuntimeException(e);
        }
    }
    @DeleteMapping("/{account_id}")
    public void deleteAccount(@PathVariable String clientID, @PathVariable String account_id){
        try {
            accountDataService.delete(clientID, account_id);
            transactionDataService.delete(account_id);
        } catch (AccountNotFound | ClientNotFound e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/{account_id}/withdraw")
    public void withdraw(@PathVariable String account_id, @RequestParam double amount, @PathVariable String clientID){
        try {
            transactionWithdraw.execute(accountDataService.getClientWithdrawAccount(clientID, account_id), amount);
        } catch (NotEnoughMoney | NegativeAmount | AccountNotWithdraw | AccountNotFound e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/{account_id}/deposit")
    public void deposit(@PathVariable String account_id, @RequestParam double amount, @PathVariable String clientID){
        try {
            transactionDeposit.execute(getAccount(clientID, account_id), amount);
        } catch (NegativeAmount e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/{account_id}/transactions")
    public List<Transaction> getTransactions(@PathVariable String clientID, @PathVariable String account_id){
        try{
            accountDataService.getClientAccount(clientID, account_id);
        } catch (AccountNotFound e) {
            throw new RuntimeException(e);
        }
        return transactionDataService.getAccountTransactions(account_id);
    }
}
