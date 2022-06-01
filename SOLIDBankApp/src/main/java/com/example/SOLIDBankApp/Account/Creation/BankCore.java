package com.example.SOLIDBankApp.Account.Creation;

import com.example.SOLIDBankApp.Account.Accounts.AccountType;
import com.example.SOLIDBankApp.Exceptions.IncorrectAccount;

public class BankCore {
    private static final long id = 1;
    private long lastAccountNumber = 1;
    private final AccountCreationService accountCreation;

    public BankCore(AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }

   public void createNewAccount(AccountType accountType, String clientID){
        if(accountType == null){
            try {
                throw new IncorrectAccount();
            } catch (IncorrectAccount e) {
                throw new RuntimeException(e);
            }
        }
        accountCreation.create(accountType, id, clientID,  lastAccountNumber);
        incrementLastAccountNumber();
   }

   private void incrementLastAccountNumber(){
        lastAccountNumber++;
   }
}
