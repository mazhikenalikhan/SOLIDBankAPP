package com.example.SOLIDBankApp.Account.Listing;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Account.Accounts.AccountType;
import com.example.SOLIDBankApp.Account.Services.AccountDataService;
import com.example.SOLIDBankApp.Exceptions.AccountNotFound;
import com.example.SOLIDBankApp.Exceptions.AccountNotWithdraw;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountListingServiceImpl implements AccountListingService {
    @Autowired
    private AccountDataService accountDataService;
    @Override
    public Account getClientAccount(String clientID, String accountID) {
        try {
            return accountDataService.getClientAccount(clientID, accountID);
        } catch (AccountNotFound e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account getClientWithdrawAccount(String clientID, String accountID) {
        try {
            return accountDataService.getClientWithdrawAccount(clientID, accountID);
        } catch (AccountNotWithdraw e) {
            throw new RuntimeException(e);
        }
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
