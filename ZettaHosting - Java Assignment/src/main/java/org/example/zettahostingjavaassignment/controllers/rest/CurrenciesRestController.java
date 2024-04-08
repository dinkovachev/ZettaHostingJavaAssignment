package org.example.zettahostingjavaassignment.controllers.rest;

import jakarta.persistence.EntityNotFoundException;
import org.example.zettahostingjavaassignment.models.Conversion;
import org.example.zettahostingjavaassignment.models.Currencies;
import org.example.zettahostingjavaassignment.models.ExchangeRate;
import org.example.zettahostingjavaassignment.models.dto.ConvertedAmountWithTimeStampDTO;
import org.example.zettahostingjavaassignment.services.contracts.ConversionService;
import org.example.zettahostingjavaassignment.services.contracts.CurrencyService;
import org.example.zettahostingjavaassignment.services.contracts.ExchangeRateService;
import org.example.zettahostingjavaassignment.services.contracts.HistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
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
    private final ExchangeRateService exchangeRateService;
    private final HistoryService historyService;

    public CurrenciesRestController(CurrencyService currencyService,
                                    ConversionService conversionService,
                                    ExchangeRateService exchangeRateService,
                                    HistoryService historyService) {

        this.currencyService = currencyService;
        this.conversionService = conversionService;
        this.exchangeRateService = exchangeRateService;
        this.historyService = historyService;
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
        if (resultOptional.isPresent()) {
            double convertedAmount = resultOptional.get();
            LocalDateTime timestamp = currencies.getHistory();
            ConvertedAmountWithTimeStampDTO result = new ConvertedAmountWithTimeStampDTO(convertedAmount, timestamp);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/exchangeRate")
    public ResponseEntity<Double> getExchangeRate(@RequestParam("currenciesFrom") String currenciesFrom,
                                                  @RequestParam("currenciesTo") String currenciesTo) {
        ExchangeRate exchangeRate = new ExchangeRate(currenciesFrom, currenciesTo);
        Optional<Double> resultOptional = exchangeRateService.getExchangeRate(exchangeRate);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Conversion>> getConversionHistory(
            @RequestParam(value = "transactionDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime transactionDate,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Page<Conversion> conversions = historyService.getConversionHistory(transactionDate, PageRequest.of(page, size));
        return ResponseEntity.ok()
                .header("X-total-count", String.valueOf(conversions.getTotalElements()))
                .header("X-total-pages", String.valueOf(conversions.getTotalPages()))
                .body(conversions.getContent());
    }
}
