package com.internship.atm.controller.handler;

import com.internship.atm.controller.handler.exception.BankCardNotFoundExeption;
import com.internship.atm.controller.handler.exception.NotEnoughMoneyExeption;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class BaseHandler {

    @ExceptionHandler(BankCardNotFoundExeption.class)
    public BaseResponse handlerNotFoundException(BankCardNotFoundExeption ex) {
        return BaseResponse.buildErrorResponse(404, ex.getMessage());
    }

    @ExceptionHandler(BankCardNotFoundExeption.class)
    public BaseResponse handlerNotEnoughMoneyExeption(NotEnoughMoneyExeption ex) {
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
