package org.example.zettahostingjavaassignment.controllers;


import org.example.zettahostingjavaassignment.services.contracts.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeRestController {

    private ExchangeService exchangeService;

    @Autowired
    public ExchangeRestController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }


}
