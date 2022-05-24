package com.example.solidbankapp.Account.Creation;

import com.example.solidbankapp.Account.Accounts.*;
import com.example.solidbankapp.Account.DAO.AccountDAO;

public class AccountCreationServiceImpl implements AccountCreationService {
    private final AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }


    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        Account newAccount = null;
        String accountNumber = String.format("%03d%06d", bankID, accountID);
        switch (accountType) {
            case FIXED -> newAccount = new FixedAccount(accountType, accountNumber, clientID, 0.0, false);
            case SAVING -> newAccount = new SavingAccount(accountType, accountNumber, clientID, 0.0, true);
            case CHECKING -> newAccount = new CheckingAccount(accountType, accountNumber, clientID, 0.0, true);
        }
        accountDAO.createNewAccount(newAccount);
    }
}
