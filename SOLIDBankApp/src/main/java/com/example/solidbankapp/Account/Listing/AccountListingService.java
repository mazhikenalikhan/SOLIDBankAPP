package com.example.solidbankapp.Account.Listing;

import com.example.solidbankapp.Account.Accounts.Account;
import com.example.solidbankapp.Account.Accounts.AccountType;
import com.example.solidbankapp.Account.Accounts.AccountWithdraw;

import java.util.List;
public interface AccountListingService {
    Account getClientAccount(String clientID, String accountID);
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
