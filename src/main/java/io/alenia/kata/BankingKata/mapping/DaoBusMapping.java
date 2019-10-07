package io.alenia.kata.BankingKata.mapping;

import io.alenia.kata.BankingKata.Business.AccountBUS;
import io.alenia.kata.BankingKata.Business.OperationBUS;
import io.alenia.kata.BankingKata.entity.Account;
import io.alenia.kata.BankingKata.entity.Operation;

public class DaoBusMapping {


    public static Account accountBusToDao(AccountBUS accountBUS){
        return new Account(accountBUS.getAccountOwner(),accountBUS.getAccountBalance());
    }

    public static AccountBUS accountDaoToBus(Account account){
        return new AccountBUS(account.getAccountId(),account.getAccountOwner(),account.getAccountBalance());
    }

    public static OperationBUS OperationDAOtoBUS(Operation operation){
        return new OperationBUS(operation.getAccount().getAccountId(),0,operation.getTypeOperation().toString(),operation.getAmount(),operation.getDateOperation().toString());
    }
}
