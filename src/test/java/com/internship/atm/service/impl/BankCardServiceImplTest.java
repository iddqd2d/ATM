package com.internship.atm.service.impl;

import com.internship.atm.model.BankCardEntity;
import com.internship.atm.service.BankCardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.yml")
public class BankCardServiceImplTest {

    @Autowired
    BankCardService bankCardService;

    @Test
    public void loadBankCardEntityByNumber() {
        BankCardEntity entity = bankCardService.loadBankCardEntityByNumber("2");
       log.info(entity.toString());
    }

    @Test
    public void addCash() {
        BankCardEntity entity = bankCardService.loadBankCardEntityByNumber("1");
        log.info(entity.toString());
        bankCardService.addCash(entity.getCardNumber(), 100);
        log.info(entity.toString());
    }
}