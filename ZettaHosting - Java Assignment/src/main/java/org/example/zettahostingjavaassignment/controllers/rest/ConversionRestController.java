package org.example.zettahostingjavaassignment.controllers.rest;


import org.example.zettahostingjavaassignment.models.Conversion;
import org.example.zettahostingjavaassignment.models.dto.ConvertedAmountWithTimeStampDTO;
import org.example.zettahostingjavaassignment.services.contracts.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/convert")
public class ConversionRestController {

    private final ConversionService conversionService;

    @Autowired
    public ConversionRestController(ConversionService conversionService) {

        this.conversionService = conversionService;
    }

    @GetMapping
    public ResponseEntity<List<Conversion>> findAll() {
        return ResponseEntity.ok(conversionService.findAll());
    }

    //Moved the logic to the CurrenciesRestController since JS couldn't recognize the endpoint correctly
    // Better to have it separately to follow the SingleResponsibility Principle
    @PostMapping
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


}
