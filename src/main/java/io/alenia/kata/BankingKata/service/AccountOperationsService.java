package io.alenia.kata.BankingKata.service;

import io.alenia.kata.BankingKata.Business.AccountBUS;
import io.alenia.kata.BankingKata.entity.Account;
import java.util.List;

public interface AccountOperationsService {

    void applyOperation(String op,long account, int amount);
    List<Account> getAccounts();
    void saveAccount(AccountBUS account);
    Account getAccountByOwnerId(long accountOwner);

}
