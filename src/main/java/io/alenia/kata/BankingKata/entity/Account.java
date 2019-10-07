package io.alenia.kata.BankingKata.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@DynamicUpdate
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

    private String accountOwner;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Operation> accountOperations;
    private int accountBalance;



    public Account(String accountOwner,int accountBalance){
        this.accountOwner = accountOwner;
        this.accountOperations = new ArrayList<>();
        this.accountBalance = accountBalance;

    }

    public void depositAction(int amountToDeposit){
        setAccountBalance(accountBalance+=amountToDeposit);
    }

    public List<Operation> getAccountOperations(){
        if (this.accountOperations == null) return new ArrayList<>();
        return this.accountOperations;
    }
    public void setAccountBalance(int amount){
        this.accountBalance = amount;
    }
    public void withdrawalAction(int amountToRetrieve){
        setAccountBalance(accountBalance-=amountToRetrieve);
    }
}
