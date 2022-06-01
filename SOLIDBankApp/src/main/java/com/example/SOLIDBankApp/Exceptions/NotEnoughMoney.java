package com.example.SOLIDBankApp.Exceptions;

import lombok.Getter;

@Getter
public class NotEnoughMoney extends Exception{
    private final String message;
    public NotEnoughMoney(String accountID){
        this.message = "Account " + accountID + " does not have enough money\n";
    }
}
