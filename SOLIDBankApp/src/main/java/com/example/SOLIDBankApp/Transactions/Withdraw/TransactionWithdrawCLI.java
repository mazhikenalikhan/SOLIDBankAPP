package com.example.SOLIDBankApp.Transactions.Withdraw;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Account.Listing.AccountListingService;
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

    public void withdrawMoney(String clientID){
        String accountID = withdrawDepositOperationCLIUI.requestClientAmountNumber();
        Account account = accountListingService.getClientWithdrawAccount(clientID, accountID);
        if(account == null){
            System.out.println("FAILED: Impossible to find withdraw-allowed account");
            return;
        }
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        transactionWithdraw.execute(account, amount);
    }
}
