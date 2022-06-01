package com.example.SOLIDBankApp.Exceptions;

import lombok.Getter;

@Getter
public class AccountNotFound extends Exception{
    private final String message;

    public AccountNotFound(String clientID, String accountID){
        this.message = "Client " + clientID + " does not have account " + accountID + "\n";
    }
}
