package org.example.zettahostingjavaassignment.controllers.rest;

import org.example.zettahostingjavaassignment.models.ExchangeRate;
import org.example.zettahostingjavaassignment.services.contracts.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/exchangeRate")
public class ExchangeRateRestController {

    private final ExchangeRateService exchangeRateService;

    @Autowired
    public ExchangeRateRestController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    //Moved the logic to the CurrenciesRestController since JS couldn't recognize the endpoint correctly
    // Better to have it separately to follow the SingleResponsibility Principle
    @GetMapping
    public ResponseEntity<Double> getExchangeRate(@RequestBody ExchangeRate exchangeRate) {
        Optional<Double> resultOptional = exchangeRateService.getExchangeRate(exchangeRate);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
