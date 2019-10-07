package io.alenia.kata.BankingKata.Business;

import io.alenia.kata.BankingKata.entity.OperationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class AccountBUS {

    private long accountId;
    private String accountOwner;
    private int accountBalance;

    public AccountBUS(long accountId,String accountOwner, int accountBalance){
        this.accountId = accountId;
        this.accountOwner = accountOwner;
        this.accountBalance = accountBalance;
    }
}
