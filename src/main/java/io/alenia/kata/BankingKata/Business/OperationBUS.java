package io.alenia.kata.BankingKata.Business;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OperationBUS {

    private long fromAccount;
    private long toAccount;
    private String typeOperation;
    private int amount;
    private String dateOperation;



}
