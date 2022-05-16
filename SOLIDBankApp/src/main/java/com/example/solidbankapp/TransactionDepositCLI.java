package com.example.solidbankapp;

import java.util.PrimitiveIterator;

public class TransactionDepositCLI {
    private TransactionDeposit transactionDeposit;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListingService;

    TransactionDepositCLI(TransactionDeposit transactionDeposit, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService){
        this.transactionDeposit = transactionDeposit;
        this.accountListingService = accountListingService;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
    }

    public void depositMoney(String clientID){
        String accountID = withdrawDepositOperationCLIUI.requestClientAmountNumber();
        Account account = accountListingService.getClientAccount(clientID, accountID);
        if(account == null){
            System.out.println("FAILED: Impossible to find account");
            return;
        }
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        transactionDeposit.execute(account, amount);
    }
}
