package org.example.zettahostingjavaassignment.controllers;

import org.example.zettahostingjavaassignment.services.contracts.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currencies")
public class CurrenciesRestController {

    private CurrencyService currencyService;

    @Autowired
    public CurrenciesRestController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }
}
