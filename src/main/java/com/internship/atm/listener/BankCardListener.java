package com.internship.atm.listener;

import com.internship.atm.model.BankCardEntity;

import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class BankCardListener {

    @PrePersist
    public void prePersist(BankCardEntity entity) {
        entity.setNumber(ThreadLocalRandom.current().nextLong(1L, 9999_9999_9999_9999L))
                .setCvv(ThreadLocalRandom.current().nextInt(0, 999))
                .setPin(ThreadLocalRandom.current().nextInt(0, 9999))
                .setValidThru(LocalDate.now().plusYears(3));

    }
}
