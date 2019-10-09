package com.internship.atm.controller.handler;

import com.internship.atm.controller.handler.exception.BankCardNotFoundException;
import com.internship.atm.controller.handler.exception.NotEnoughMoneyException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class BaseHandler {

    @ExceptionHandler(BankCardNotFoundException.class)
    public BaseResponse handlerNotFoundException(BankCardNotFoundException ex) {
        return BaseResponse.buildErrorResponse(404, ex.getMessage());
    }

    @ExceptionHandler(BankCardNotFoundException.class)
    public BaseResponse handlerNotEnoughMoneyExeption(NotEnoughMoneyException ex) {
        return BaseResponse.buildErrorResponse(404, ex.getMessage());
    }

    @Setter
    @Getter
    private static class BaseResponse {
        private int errorCode = 200;
        private boolean success = true;
        private String errorMessage;

        static BaseResponse buildErrorResponse(int errorCode, String errorMessage) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setErrorCode(errorCode);
            baseResponse.setErrorMessage(errorMessage);
            baseResponse.setSuccess(Boolean.FALSE);
            return baseResponse;
        }
    }
}
