package com.example.SOLIDBankApp.Account.Accounts;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "ACCOUNTS")
@Data
@Builder
@AllArgsConstructor
public class Account {
    private @Id String accountID;
    private String clientID;
    private AccountType accountType;
    private double balance;
    private boolean withdrawAllowed;

    @Override
    public String toString() {
        return "Account{, id=" + accountID + ", clientID=" + clientID + ", balance=" + balance + "}";
    }

}
