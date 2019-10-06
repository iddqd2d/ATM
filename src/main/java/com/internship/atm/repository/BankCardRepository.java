package com.internship.atm.repository;

import com.internship.atm.model.BankCardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardRepository extends CrudRepository<BankCardEntity, Integer> {
}
