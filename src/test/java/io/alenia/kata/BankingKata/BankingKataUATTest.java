package io.alenia.kata.BankingKata;


import io.alenia.kata.BankingKata.entity.Account;
import io.alenia.kata.BankingKata.repository.AccountRepository;
import io.alenia.kata.BankingKata.service.AccountOperationsService;
import io.alenia.kata.BankingKata.service.imp.AccountOperationsServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BankingKataUATTest {


    private AccountRepository accountRepository = Mockito.mock(AccountRepository.class);
    private AccountOperationsService accountOperationsService;

    @Before
    public void initTests(){
        accountOperationsService = new AccountOperationsServiceImp(accountRepository);
        when(accountRepository.getByAccountId(anyLong())).thenReturn(new Account("account1",1000));
    }


    @Test
    public void depositMoney_NotFoundAccount_ExceptionThrown(){
        when(accountRepository.getByAccountId(anyLong())).thenReturn(null);
        Account account = accountOperationsService.getAccountByOwnerId(1);
        assertThatNullPointerException().isThrownBy(() ->account.getAccountBalance());
    }

    @Test
    public void depositMoney_FoundAccount_returnEntity(){
        Account account = accountOperationsService.getAccountByOwnerId(1);
        assertThat(account).isNotNull();
    }

    @Test
    public void depositMoney_FoundAccount_returnBalance(){
        Account account = accountOperationsService.getAccountByOwnerId(1);
        accountOperationsService.applyOperation("DEPOSIT",1,400);
        assertThat(account.getAccountBalance()).isEqualTo(1400);
    }

    @Test
    public void withdrawalMoney_FoundAccount_returnBalance() {
        Account account = accountOperationsService.getAccountByOwnerId(1);
        accountOperationsService.applyOperation("WITHDRAWAL", 1, 400);
        assertThat(account.getAccountBalance()).isEqualTo(600);
    }



}
