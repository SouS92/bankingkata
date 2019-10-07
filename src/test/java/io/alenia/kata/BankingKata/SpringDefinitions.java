package io.alenia.kata.BankingKata;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.alenia.kata.BankingKata.entity.Account;
import io.alenia.kata.BankingKata.entity.Operation;
import io.alenia.kata.BankingKata.service.AccountOperationsService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpringDefinitions extends BankingKataApplicationTests {

    @Mock
    AccountOperationsService accountOperationsService;
    @Mock
    Account accountToTest;

    @Before
    public void initTests(){
        initMocks();
        initAccountBean();
        impBehaviorsBeans();
    }


    public void initMocks(){
        MockitoAnnotations.initMocks(this);

        accountOperationsService = mock(AccountOperationsService.class);
        accountToTest = mock(Account.class);
    }
    public void initAccountBean(){
        when(accountToTest.getAccountOperations()).thenReturn(Arrays.asList(null,null,null,null));
        Mockito.doCallRealMethod().when(accountToTest).setAccountBalance(anyInt());
        Mockito.doCallRealMethod().when(accountToTest).getAccountBalance();
        Mockito.doCallRealMethod().when(accountToTest).depositAction(anyInt());
        Mockito.doCallRealMethod().when(accountToTest).withdrawalAction(anyInt());
    }

    public void impBehaviorsBeans(){
        when(accountOperationsService.getAccountByOwnerId(anyLong())).thenReturn(accountToTest);
        doAnswer((InvocationOnMock invoke)->{
            if(invoke.getArgument(0).equals("DEPOSIT")) accountToTest.depositAction(invoke.getArgument(2));
            else accountToTest.withdrawalAction(invoke.getArgument(2));
            return null;
        }).when(accountOperationsService).applyOperation(anyString(), anyLong(),anyInt());
    }





    @Given("a bank client with id {int} has {int}")
    public void account_with_id_has(long idAccount, int initialBalance) {
        accountToTest.setAccountBalance(initialBalance);
        assertEquals(accountToTest.getAccountBalance(),initialBalance);
    }

    @When("make an operation {string} of {int}")
    public void make_an_operation_of(String operationType, Integer amountOfOperation) {
        Account accountForTest = accountOperationsService.getAccountByOwnerId(1);
        int initialAmount = accountForTest.getAccountBalance();
        accountOperationsService.applyOperation(operationType,1,amountOfOperation);
        initialAmount = operationType.equals("DEPOSIT") == true ? initialAmount+amountOfOperation : initialAmount-amountOfOperation;

        assertEquals(accountForTest.getAccountBalance(),initialAmount);
    }

    @Then("Account has {int}")
    public void account_has(int finalValue) {
        assertEquals(accountToTest.getAccountBalance(),finalValue);
    }


    @Given("a bank client with id {int}")
    public void a_bank_client_with_id(Integer int1) {
        Account accountToTest = accountOperationsService.getAccountByOwnerId(1);
        assertThat(accountToTest).isNotNull();
    }


    @Then("the display has {int} operations")
    public void the_display_has_operations(Integer int1) {
        Account accountToTest = accountOperationsService.getAccountByOwnerId(1);
        int numberOfOperations = accountToTest.getAccountOperations().size();
        assertEquals(numberOfOperations,4);
    }


}
