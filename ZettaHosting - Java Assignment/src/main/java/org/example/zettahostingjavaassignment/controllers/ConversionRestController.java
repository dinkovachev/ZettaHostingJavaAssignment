package org.example.zettahostingjavaassignment.controllers;


import org.example.zettahostingjavaassignment.models.Conversion;
import org.example.zettahostingjavaassignment.models.dto.ConvertedAmountWithTimeStampDTO;
import org.example.zettahostingjavaassignment.services.contracts.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@RestController
@RequestMapping("/api/convert")
public class ConversionRestController {

    private final ConversionService conversionService;

    @Autowired
    public ConversionRestController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @PostMapping
    public ResponseEntity<ConvertedAmountWithTimeStampDTO> convertCurrencies(@RequestBody Conversion currencies) {
        currencies.setHistory(Timestamp.from(Instant.now()));
        Optional<Double> resultOptional = conversionService.convert(currencies);
        if (resultOptional.isPresent()){
            double convertedAmount = resultOptional.get();
            Timestamp timestamp = currencies.getHistory();
            ConvertedAmountWithTimeStampDTO result = new ConvertedAmountWithTimeStampDTO(convertedAmount, timestamp);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
