package io.alenia.kata.BankingKata.controller;

import io.alenia.kata.BankingKata.Business.AccountBUS;
import io.alenia.kata.BankingKata.entity.Account;
import io.alenia.kata.BankingKata.mapping.DaoBusMapping;
import io.alenia.kata.BankingKata.service.AccountOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountOperationsService accountService;

    @GetMapping
    public List<AccountBUS> getAccounts(){
        return accountService.getAccounts().stream().map(x -> DaoBusMapping.accountDaoToBus(x)).collect(Collectors.toList());
    }

    @GetMapping("/{idAccount}")
    public Account getAccount(@PathVariable long idAccount){
        return accountService.getAccountByOwnerId(idAccount);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED, reason = "Account inserted")
    public void insertAccount(@RequestBody AccountBUS account){
        accountService.saveAccount(account);
    }
}
