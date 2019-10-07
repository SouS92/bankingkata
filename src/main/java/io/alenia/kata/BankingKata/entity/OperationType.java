package io.alenia.kata.BankingKata.entity;

public enum OperationType {

    DEPOSIT("Deposit"),WITHDRAWAL("Withdrawal");

    private String opTypeName;

    OperationType(String opName){
        this.opTypeName = opName;
    }

}
