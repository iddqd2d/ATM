package com.internship.atm.controller.handler.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class BankCardNotFoundExeption extends RuntimeException {

    private static String message = "Cannot find card by number: ";

    public BankCardNotFoundExeption(String number) {
        super(message + number);
        log.error(message + number);
    }
}
