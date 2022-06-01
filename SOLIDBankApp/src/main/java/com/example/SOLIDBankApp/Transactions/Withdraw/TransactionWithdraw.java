package com.example.SOLIDBankApp.Transactions.Withdraw;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Exceptions.AccountNotFound;
import com.example.SOLIDBankApp.Exceptions.NegativeAmount;
import com.example.SOLIDBankApp.Exceptions.NotEnoughMoney;
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

    public void execute(Account accountWithdraw, double amount) throws NotEnoughMoney, NegativeAmount, AccountNotFound{
        if(amount <= 0) throw new NegativeAmount();
        if(accountWithdraw.getBalance() < amount) {
            throw new NotEnoughMoney(accountWithdraw.getAccountID());
        }
        accountWithdrawService.withdraw(amount, accountWithdraw);
        Transaction transaction = new Transaction(transactionDataService.getID(), accountWithdraw.getAccountID(), -amount);
        transactionDataService.addTransaction(transaction);
    }
}
