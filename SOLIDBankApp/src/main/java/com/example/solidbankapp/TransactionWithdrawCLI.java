package com.example.solidbankapp;

import java.util.List;

public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListingService;

    TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService){
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }

    public void withdrawMoney(String clientID){
        String accountID = withdrawDepositOperationCLIUI.requestClientAmountNumber();
        AccountWithdraw account = accountListingService.getClientWithdrawAccount(clientID, accountID);
        if(account == null){
            System.out.println("FAILED: Impossible to find withdrawallowed account");
            return;
        }
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        transactionWithdraw.execute(account, amount);
    }
}
