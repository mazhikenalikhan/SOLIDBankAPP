package com.example.solidbankapp.Account.Creation;

import com.example.solidbankapp.Account.Accounts.AccountType;

public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
