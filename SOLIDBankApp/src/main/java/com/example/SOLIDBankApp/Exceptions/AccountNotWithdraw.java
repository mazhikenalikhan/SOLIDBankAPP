package com.example.SOLIDBankApp.Exceptions;

import lombok.Getter;

@Getter
public class AccountNotWithdraw extends Exception{
    private final String message;
    public AccountNotWithdraw(String clientID, String accountID){
        this.message = "Account " + accountID + " of client " + clientID + " either does not exists or not allows withdraw\n";
    }
}
