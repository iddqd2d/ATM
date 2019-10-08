package com.internship.atm.repository;

import com.internship.atm.model.BankCardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankCardRepository extends CrudRepository<BankCardEntity, Integer> {
    Optional<BankCardEntity> getBankCardEntityByCardNumber(String cardNumber);
}
