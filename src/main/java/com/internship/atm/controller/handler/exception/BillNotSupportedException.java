package com.internship.atm.controller.handler.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class BillNotSupportedException  extends RuntimeException{
    private static String message = "Bill not supported: ";

    public BillNotSupportedException(Long money) {
        super(message + money);
        log.error(message + money);
    }
}
