package org.example.zettahostingjavaassignment.controllers.rest;

import jakarta.persistence.EntityNotFoundException;
import org.example.zettahostingjavaassignment.models.Currencies;
import org.example.zettahostingjavaassignment.services.contracts.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/currencies")
public class CurrenciesRestController {

    private final CurrencyService currencyService;


    public CurrenciesRestController(CurrencyService currencyService) {

        this.currencyService = currencyService;
    }

    @GetMapping
    public ResponseEntity<List<Currencies>> getAllCurrencies() {
        try {
            return new ResponseEntity<>(currencyService.getAllCurrencies(), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/currencyName:")
    public Optional<Currencies> getByName(@RequestParam String name) {
        try {
            return currencyService.getByName(name);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
