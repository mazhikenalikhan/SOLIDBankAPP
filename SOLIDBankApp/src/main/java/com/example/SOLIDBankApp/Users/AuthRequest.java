package com.example.SOLIDBankApp.Users;


import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}