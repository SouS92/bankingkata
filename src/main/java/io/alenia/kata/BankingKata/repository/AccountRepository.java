package io.alenia.kata.BankingKata.repository;

import io.alenia.kata.BankingKata.entity.Account;
import io.alenia.kata.BankingKata.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    List<Operation> getAccountOperationsByAccountId(long accountOwner);
    Account getByAccountId(long accountOwner);


}
