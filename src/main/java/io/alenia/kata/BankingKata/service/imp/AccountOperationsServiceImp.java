package io.alenia.kata.BankingKata.service.imp;

import io.alenia.kata.BankingKata.Business.AccountBUS;
import io.alenia.kata.BankingKata.entity.Account;
import io.alenia.kata.BankingKata.entity.Operation;
import io.alenia.kata.BankingKata.entity.OperationType;
import io.alenia.kata.BankingKata.mapping.DaoBusMapping;
import io.alenia.kata.BankingKata.repository.AccountRepository;
import io.alenia.kata.BankingKata.service.AccountOperationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AccountOperationsServiceImp implements AccountOperationsService {

    private final AccountRepository accountRepository;


    @Override
    public void applyOperation(String op, long account, int amount) {
        Account accountToApplyOperation = getAccountByOwnerId(account);
        Operation newOperation = new Operation(accountToApplyOperation,OperationType.valueOf(op),-amount);

        OperationType type = OperationType.valueOf(op);
        switch (type){
            case DEPOSIT: accountToApplyOperation.depositAction(amount); break;
            default: accountToApplyOperation.withdrawalAction(amount); break;
        }
        accountToApplyOperation.getAccountOperations().add(newOperation);
        accountRepository.save(accountToApplyOperation);
    }

    @Override
    public List<Account> getAccounts() {
        return StreamSupport
                .stream(accountRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public void saveAccount(AccountBUS accountBUS) {
        Account account = DaoBusMapping.accountBusToDao(accountBUS);
        accountRepository.save(account);
    }

    @Override
    public Account getAccountByOwnerId(long accountOwner) {

        return accountRepository.getByAccountId(accountOwner);
    }
}
