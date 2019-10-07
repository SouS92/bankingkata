package io.alenia.kata.BankingKata.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter @Getter @NoArgsConstructor
public class Operation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOperation;
    private OperationType typeOperation;
    private int amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="accountId")
    @JsonIgnore
    private Account account;
    private LocalDate dateOperation = LocalDate.now();

    public Operation(Account account,OperationType typeOperation, int amount){
        this.account = account;
        this.typeOperation = typeOperation;
        this.amount = amount;
    }
}
