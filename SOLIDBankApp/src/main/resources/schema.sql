CREATE TABLE ACCOUNTS
(
    ACCOUNT_ID NVARCHAR(40)  NOT NULL,
    CLIENT_ID NVARCHAR(40),
    ACCOUNT_TYPE NVARCHAR(40),
    BALANCE DOUBLE,
    WITHDRAW_ALLOWED BOOLEAN,
    CONSTRAINT PK_ACCOUNTS PRIMARY KEY  (ACCOUNT_ID)
);
CREATE TABLE TRANSACTIONS
(
    ID NVARCHAR(40) NOT NULL,
    ACCOUNT_ID NVARCHAR(40),
    AMOUNT DOUBLE,
    CONSTRAINT PK_TRANSACTIONS PRIMARY KEY  (ID)
);
create table USERS
(
    id       serial not null
        constraint user_table_pk
            primary key,
    login    varchar(50),
    password varchar(500),
    role varchar(50)
);