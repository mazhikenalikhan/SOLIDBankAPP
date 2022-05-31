package com.example.SOLIDBankApp.Account.DAO;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Account.Accounts.AccountType;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
    @Query("SELECT * FROM ACCOUNTS WHERE CLIENT_ID = :1 and ACCOUNT_ID = :2;")
    Account getClientAccount(@Param("1")String clientID,@Param("2") String accountID);
    @Query("SELECT * FROM ACCOUNTS WHERE CLIENT_ID = :1 and ACCOUNT_ID = :2 and WITHDRAW_ALLOWED = true;")
    Account getClientWithdrawAccount(@Param("1")String clientID,@Param("2") String accountID);
    @Query("SELECT * FROM ACCOUNTS WHERE CLIENT_ID = :1;")
    List<Account> getClientAccounts(@Param("1")String clientID);
    @Query("SELECT * FROM ACCOUNTS WHERE CLIENT_ID = :1 and ACCOUNT_TYPE = :2;")
    List<Account> getClientAccountsByType(@Param("1") String clientID,@Param("2") AccountType accountType);
    @Modifying
    @Query(value ="INSERT INTO ACCOUNTS (ACCOUNT_ID) VALUES(:1);")
    void create(@Param("1") String ACCOUNT_ID);

}
