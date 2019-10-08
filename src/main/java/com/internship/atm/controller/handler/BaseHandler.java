package com.internship.atm.controller.handler;

import com.internship.atm.controller.handler.exception.BankCardNotFoundExeption;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class BaseHandler {

    @ExceptionHandler(BankCardNotFoundExeption.class)
    public BaseResponse handlerNotFoundException(BankCardNotFoundExeption ex) {
        return BaseResponse.buildErrorResponse(ex.getMessage());
    }

    @Setter
    @Getter
    private static class BaseResponse {
        private boolean success = true;
        private String errorMessage;

        static BaseResponse buildErrorResponse(String errorMessage) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setErrorMessage(errorMessage);
            baseResponse.setSuccess(Boolean.FALSE);
            return baseResponse;
        }
    }
}
