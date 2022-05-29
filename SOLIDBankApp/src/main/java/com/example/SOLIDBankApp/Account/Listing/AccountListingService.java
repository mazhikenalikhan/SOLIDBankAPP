package com.example.SOLIDBankApp.Account.Listing;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Account.Accounts.AccountType;

import java.util.List;
public interface AccountListingService {
    Account getClientAccount(String clientID, String accountID);
    Account getClientWithdrawAccount(String clientID, String accountID);
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
