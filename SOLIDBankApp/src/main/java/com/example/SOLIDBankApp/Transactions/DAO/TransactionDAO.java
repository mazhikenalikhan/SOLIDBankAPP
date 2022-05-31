package com.example.SOLIDBankApp.Transactions.DAO;

import com.example.SOLIDBankApp.Transactions.Transaction;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDAO extends CrudRepository<Transaction, String> {
    @Modifying
    @Query(value ="INSERT INTO TRANSACTIONS (ID) VALUES(:1);")
    void add(@Param("1") String id);

    @Query("SELECT * FROM TRANSACTIONS;")
    List<Transaction> getTransactions();
}
