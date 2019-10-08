package com.internship.atm.service.impl;

import com.internship.atm.controller.handler.exception.BankCardNotFoundExeption;
import com.internship.atm.controller.handler.exception.NotEnoughMoneyExeption;
import com.internship.atm.model.BankCardEntity;
import com.internship.atm.repository.BankCardRepository;
import com.internship.atm.service.BankCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BankCardServiceImpl implements BankCardService {
    private final BankCardRepository repository;

    @Override
    public BankCardEntity loadBankCardEntityByNumber(String cardNumber) {
        return repository.getBankCardEntityByCardNumber(cardNumber).orElseThrow(() -> new BankCardNotFoundExeption(cardNumber));
    }

    @Override
    public void addCash(String cardNumber, long cash) {
        BankCardEntity entity = loadBankCardEntityByNumber(cardNumber);
        entity.setBalance(entity.getBalance() + cash);
        repository.save(entity);
    }

    @Override
    public void getCash(String cardNumber, long cash) {
        BankCardEntity entity = loadBankCardEntityByNumber(cardNumber);
        long result = entity.getBalance() - cash;
        if (result < 0){
                throw new NotEnoughMoneyExeption(result);
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
