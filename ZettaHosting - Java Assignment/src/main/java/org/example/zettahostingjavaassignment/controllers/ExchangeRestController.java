package org.example.zettahostingjavaassignment.controllers;


import org.example.zettahostingjavaassignment.models.Currencies;
import org.example.zettahostingjavaassignment.models.Exchanges;
import org.example.zettahostingjavaassignment.services.contracts.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeRestController {

    private ExchangeService exchangeService;

    @Autowired
    public ExchangeRestController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping
    public ResponseEntity<Double> convertCurrencies(@RequestBody Exchanges currencies) {
        Optional<Double> resultOptional = exchangeService.convert(currencies);
        if (resultOptional.isPresent()){
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }


}
