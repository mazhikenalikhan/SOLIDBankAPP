package com.example.solidbankapp;

public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
