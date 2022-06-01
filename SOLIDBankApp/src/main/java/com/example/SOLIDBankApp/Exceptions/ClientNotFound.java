package com.example.SOLIDBankApp.Exceptions;

import lombok.Getter;

@Getter
public class ClientNotFound extends Exception{
    private final String message;
    public ClientNotFound(String id){
        this.message = "Client " + id + " does not exist\n";
    }
}
