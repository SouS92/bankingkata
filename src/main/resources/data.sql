INSERT INTO ACCOUNT(account_balance,account_owner) values (1000,'account1')
INSERT INTO ACCOUNT(account_balance,account_owner)  values (2000, 'account2')

INSERT INTO operation (amount,type_operation,account_id,date_operation) values (1300,0,1,now())
INSERT INTO operation (amount,type_operation,account_id,date_operation) values (100,0,1,now())

INSERT INTO operation (amount,type_operation,account_id,date_operation) values (300,1,1,now())