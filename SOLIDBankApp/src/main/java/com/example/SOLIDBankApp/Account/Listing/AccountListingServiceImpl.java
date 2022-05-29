package com.example.SOLIDBankApp.Account.Listing;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Account.Accounts.AccountType;
import com.example.SOLIDBankApp.Account.Services.AccountDataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountListingServiceImpl implements AccountListingService {
    @Autowired
    private AccountDataService accountDataService;
    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountDataService.getClientAccount(clientID, accountID);
    }

    @Override
    public Account getClientWithdrawAccount(String clientID, String accountID) {
        return accountDataService.getClientWithdrawAccount(clientID, accountID);
    }

    @Override
    public List<Account> getClientAccounts(String clientID){
        return accountDataService.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountDataService.getClientAccountsByType(clientID, accountType);
    }
}
