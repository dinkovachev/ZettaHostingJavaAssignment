package org.example.zettahostingjavaassignment.controllers.rest;

import jakarta.persistence.EntityNotFoundException;
import org.example.zettahostingjavaassignment.models.Conversion;
import org.example.zettahostingjavaassignment.models.Currencies;
import org.example.zettahostingjavaassignment.models.dto.ConvertedAmountWithTimeStampDTO;
import org.example.zettahostingjavaassignment.services.contracts.ConversionService;
import org.example.zettahostingjavaassignment.services.contracts.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/currencies")
public class CurrenciesRestController {

    private final CurrencyService currencyService;
    private final ConversionService conversionService;

    public CurrenciesRestController(CurrencyService currencyService, ConversionService conversionService) {

        this.currencyService = currencyService;
        this.conversionService = conversionService;
    }

    @GetMapping
    public ResponseEntity<List<Currencies>> getAllCurrencies() {
        try {
            return new ResponseEntity<>(currencyService.getAllCurrencies(), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/convert")
    public ResponseEntity<ConvertedAmountWithTimeStampDTO> convertCurrencies(@RequestBody Conversion currencies) {
        currencies.setHistory(LocalDateTime.now());
        Optional<Double> resultOptional = conversionService.convert(currencies);
        if (resultOptional.isPresent()){
            double convertedAmount = resultOptional.get();
            LocalDateTime timestamp = currencies.getHistory();
            ConvertedAmountWithTimeStampDTO result = new ConvertedAmountWithTimeStampDTO(convertedAmount, timestamp);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
