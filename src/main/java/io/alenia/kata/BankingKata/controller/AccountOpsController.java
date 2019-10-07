package io.alenia.kata.BankingKata.controller;

import io.alenia.kata.BankingKata.Business.OperationBUS;
import io.alenia.kata.BankingKata.entity.OperationType;
import io.alenia.kata.BankingKata.mapping.DaoBusMapping;
import io.alenia.kata.BankingKata.service.AccountOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
public class AccountOpsController {
    @Autowired
    private AccountOperationsService operationsService;

    @PostMapping(value = "/{uid}/operations",headers = { "content-type=*/*"},consumes = "application/json", produces =
            "application/json")
    @ResponseStatus(value = HttpStatus.ACCEPTED,reason = "Operation done successfully")
    public void opAccount(@PathVariable long uid, @RequestBody OperationBUS op){
        operationsService.applyOperation(op.getTypeOperation(),op.getFromAccount(),op.getAmount());
    }

    @GetMapping(value = "/{uid}/operations")
    public List<OperationBUS> getListOps(@PathVariable("uid") long uid){
       return operationsService.getAccountByOwnerId(uid).getAccountOperations().stream().
                map(operation -> DaoBusMapping.OperationDAOtoBUS(operation)).collect(Collectors.toList());
    }



}
