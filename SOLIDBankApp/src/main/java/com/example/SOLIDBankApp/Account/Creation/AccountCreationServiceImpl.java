package com.example.SOLIDBankApp.Account.Creation;

import com.example.SOLIDBankApp.Account.Accounts.*;
import com.example.SOLIDBankApp.Account.Services.AccountDataService;
import com.example.SOLIDBankApp.Exceptions.AccountAlreadyExist;
import com.example.SOLIDBankApp.Exceptions.IncorrectAccount;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountCreationServiceImpl implements AccountCreationService {
    @Autowired
    private AccountDataService accountDataService;

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID){
        Account newAccount = null;
        String accountNumber = String.format("%03d%06d", bankID, accountID);
        switch (accountType) {
            case FIXED -> newAccount = new FixedAccount(accountType, accountNumber, clientID, 0.0);
            case SAVING -> newAccount = new SavingAccount(accountType, accountNumber, clientID, 0.0);
            case CHECKING -> newAccount = new CheckingAccount(accountType, accountNumber, clientID, 0.0);
        }
        try {
            accountDataService.createNewAccount(newAccount);
        } catch (AccountAlreadyExist | IncorrectAccount e) {
            throw new RuntimeException(e);
        }
    }
}
