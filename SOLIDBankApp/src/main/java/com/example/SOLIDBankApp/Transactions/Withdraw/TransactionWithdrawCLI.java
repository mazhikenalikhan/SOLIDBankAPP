package com.example.SOLIDBankApp.Transactions.Withdraw;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Account.Listing.AccountListingService;
import com.example.SOLIDBankApp.Exceptions.AccountNotFound;
import com.example.SOLIDBankApp.Exceptions.NegativeAmount;
import com.example.SOLIDBankApp.Exceptions.NotEnoughMoney;
import com.example.SOLIDBankApp.Transactions.WithdrawDepositOperationCLIUI;

public class TransactionWithdrawCLI {
    private final TransactionWithdraw transactionWithdraw;
    private final WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private final AccountListingService accountListingService;

    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService){
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }

    public void withdrawMoney(String clientID) throws NotEnoughMoney, AccountNotFound {
        String accountID = withdrawDepositOperationCLIUI.requestClientAmountNumber();
        Account account = accountListingService.getClientWithdrawAccount(clientID, accountID);
        if(account == null){
            throw new AccountNotFound(clientID, accountID);
        }
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        try {
            transactionWithdraw.execute(account, amount);
        } catch (NegativeAmount | AccountNotFound e) {
            throw new RuntimeException(e);
        }
    }
}
