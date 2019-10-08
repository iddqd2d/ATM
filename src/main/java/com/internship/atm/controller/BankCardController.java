package com.internship.atm.controller;

import com.internship.atm.service.BankCardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BankCardController {
    private BankCardService bankCardService;

    @GetMapping("/put/{cash}")
    public String addCash(@PathVariable Long cash) {
        String cardNumber = SecurityContextHolder.getContext().getAuthentication().getName();
        bankCardService.addCash(cardNumber, cash);
        return bankCardService.loadBankCardEntityByNumber(cardNumber).toString();
    }

    @GetMapping("/get/{cash}")
    public String getCash(@PathVariable Long cash) {
        String cardNumber = SecurityContextHolder.getContext().getAuthentication().getName();
        bankCardService.getCash(cardNumber, cash);
        return bankCardService.loadBankCardEntityByNumber(cardNumber).toString();
    }

    @GetMapping("/transfer/{cardTo}/{cash}")
    public String getCash(@PathVariable String cardTo, @PathVariable Long cash) {
        String cardFrom = SecurityContextHolder.getContext().getAuthentication().getName();
        bankCardService.transferCash(cardFrom, cardTo, cash);
        return bankCardService.loadBankCardEntityByNumber(cardFrom).toString()
                + bankCardService.loadBankCardEntityByNumber(cardTo).toString();
    }
}
