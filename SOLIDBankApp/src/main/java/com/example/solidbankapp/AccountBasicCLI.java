package com.example.solidbankapp;

import java.util.List;

public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing){
        this.accountListing = accountListing;
        this.bankCore = bankCore;
        this.createAccountOperationUI = createAccountOperationUI;
    }

    public void createAccountRequest(String clientID) {
        bankCore.createNewAccount(createAccountOperationUI.requestAccountType(), clientID);
    }

    public void getAccounts(String clientID) {
        System.out.println(accountListing.getClientAccounts(clientID));
    }
}
