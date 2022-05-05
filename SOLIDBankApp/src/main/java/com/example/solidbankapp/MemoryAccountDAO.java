package com.example.solidbankapp;

import java.util.ArrayList;
import java.util.List;

public class MemoryAccountDAO implements AccountDAO{
    private List<Account> accountList;

    MemoryAccountDAO(){
        this.accountList = new ArrayList<Account>();
    }
    @Override
    public List<Account> getClientAccounts(String clientID) {
        List<Account> clientAccounts = new ArrayList<Account>();
        for(Account i : this.accountList) {
            if(i.getClientID().equals(clientID)) {
                clientAccounts.add(i);
            }
        }
        return clientAccounts;
    }

    @Override
    public void createNewAccount(Account account) {
        if(account != null){
            System.out.println("Success");
            this.accountList.add(account);
        }
        else System.out.println("Operation failed");
    }

    @Override
    public void updateAccount(Account account) {
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        List<Account> clientAccountsByType = new ArrayList<Account>();
        for(Account i : this.accountList) {
            if(i.getClientID().equals(clientID) && i.getAccountType().getType().equals(accountType.getType())) {
                clientAccountsByType.add(i);
            }
        }
        return clientAccountsByType;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        for(Account i : this.accountList) {
            if(i.getClientID().equals(clientID) && i.getId().equals(accountID) && i.isWithdrawAllowed()) {
                return (AccountWithdraw) i;
            }
        }
        return null;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        for(Account i : this.accountList) {
            if(i.getClientID().equals(clientID) && i.getId().equals(accountID)) {
                return i;
            }
        }
        return null;
    }
}
