package com.internship.atm.service;


import com.internship.atm.model.BankCardEntity;

public interface BankCardService {

    BankCardEntity loadBankCardEntityByNumber(String cardNumber);

    void addCash(String cardNumber, long cash);

    void getCash(String cardNumber, long cash);

    void transferCash(String fromCardNumber, String toCardNumber, long cash);
}
