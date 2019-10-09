package com.internship.atm.controller.handler.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class NotEnoughMoneyException extends RuntimeException{

    private static String message = "Not enough money: ";

    public NotEnoughMoneyException(Long money) {
        super(message + money);
        log.error(message + money);
    }
}
