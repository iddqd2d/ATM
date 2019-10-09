package com.internship.atm.service.impl;

import com.internship.atm.controller.handler.exception.BankCardNotFoundException;
import com.internship.atm.controller.handler.exception.BillNotSupportedException;
import com.internship.atm.controller.handler.exception.NotEnoughMoneyException;
import com.internship.atm.model.BankCardEntity;
import com.internship.atm.repository.BankCardRepository;
import com.internship.atm.service.BankCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BankCardServiceImpl implements BankCardService {
    private final BankCardRepository repository;
    @Value("${listOfBills}")
    private List<Long> bills;

    @Override
    public BankCardEntity loadBankCardEntityByNumber(String cardNumber) {
        return repository.getBankCardEntityByCardNumber(cardNumber).orElseThrow(() -> new BankCardNotFoundException(cardNumber));
    }

    @Override
    public void addCash(String cardNumber, long cash) {
        if (!bills.contains(cash)) {
            throw new BillNotSupportedException(cash);
        }
        BankCardEntity entity = loadBankCardEntityByNumber(cardNumber);
        entity.setBalance(entity.getBalance() + cash);
        repository.save(entity);
    }

    @Override
    public void getCash(String cardNumber, long cash) {
        if (!bills.contains(cash)) {
            throw new BillNotSupportedException(cash);
        }
        BankCardEntity entity = loadBankCardEntityByNumber(cardNumber);
        long result = entity.getBalance() - cash;
        if (result < 0) {
            throw new NotEnoughMoneyException(result);
        }
        entity.setBalance(entity.getBalance() - cash);
        repository.save(entity);
    }

    @Override
    public void transferCash(String fromCardNumber, String toCardNumber, long cash) {
        getCash(fromCardNumber, cash);
        addCash(toCardNumber, cash);
    }
}
