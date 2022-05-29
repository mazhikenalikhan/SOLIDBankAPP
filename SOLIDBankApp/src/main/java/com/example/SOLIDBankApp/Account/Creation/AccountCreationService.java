package com.example.SOLIDBankApp.Account.Creation;

import com.example.SOLIDBankApp.Account.Accounts.AccountType;

public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
