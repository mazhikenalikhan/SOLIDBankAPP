package com.example.SOLIDBankApp.Transactions;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "TRANSACTIONS")
@Data
@Builder
@AllArgsConstructor
public class Transaction {
    private @Id String ID;
    private String ACCOUNT_ID;
    private double AMOUNT;

}
