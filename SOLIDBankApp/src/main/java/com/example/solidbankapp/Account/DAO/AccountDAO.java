package com.example.solidbankapp.Account.DAO;

import com.example.solidbankapp.Account.Accounts.Account;
import com.example.solidbankapp.Account.Accounts.AccountType;
import com.example.solidbankapp.Account.Accounts.AccountWithdraw;

import java.util.List;

public interface AccountDAO {
    List<Account> getClientAccounts(String clientID);
    void createNewAccount(Account account);
    void updateAccount(Account account);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    Account getClientAccount(String clientID, String accountID);
}
