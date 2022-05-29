package com.example.SOLIDBankApp.Transactions.Withdraw;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Transactions.Service.TransactionDataService;
import com.example.SOLIDBankApp.Transactions.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionWithdraw {
    private final AccountWithdrawService accountWithdrawService;
    @Autowired
    private TransactionDataService transactionDataService;

    public TransactionWithdraw(AccountWithdrawService accountWithdrawService) {
        this.accountWithdrawService = accountWithdrawService;
    }

    public void execute(Account accountWithdraw, double amount){
        if(accountWithdraw.getBalance() < amount) {
            System.out.println("FAILED: Not enough money");
            return;
        }
        if(amount <= 0){
            System.out.println("FAILED: Incorrect data");
            return;
        }
        accountWithdrawService.withdraw(amount, accountWithdraw);
        Transaction transaction = new Transaction(transactionDataService.getID(), accountWithdraw, amount);
        transactionDataService.addTransaction(transaction);
        System.out.println("SUCCESS");
    }
}
