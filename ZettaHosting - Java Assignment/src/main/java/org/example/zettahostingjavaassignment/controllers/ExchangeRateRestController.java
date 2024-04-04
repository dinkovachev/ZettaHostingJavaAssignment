package org.example.zettahostingjavaassignment.controllers;

import org.example.zettahostingjavaassignment.models.dto.ExchangeRateDTO;
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

    private ExchangeRateService exchangeRateService;

    @Autowired
    public ExchangeRateRestController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping
    public ResponseEntity<Double> getExchangeRate(@RequestBody ExchangeRateDTO exchangeRateDTO) {
        Optional<Double> resultOptional = exchangeRateService.getExchangeRate(exchangeRateDTO);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
