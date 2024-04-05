package org.example.zettahostingjavaassignment.services;

import org.example.zettahostingjavaassignment.models.Currencies;
import org.example.zettahostingjavaassignment.models.Conversion;
import org.example.zettahostingjavaassignment.repositories.CurrencyRepository;
import org.example.zettahostingjavaassignment.repositories.ConversionRepository;
import org.example.zettahostingjavaassignment.services.contracts.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConversionServiceImpl implements ConversionService {

    private final ConversionRepository conversionRepository;

    private final CurrencyRepository currencyRepository;

    @Autowired
    public ConversionServiceImpl(ConversionRepository conversionRepository, CurrencyRepository currencyRepository) {
        this.conversionRepository = conversionRepository;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Optional<Double> convert(Conversion currencies) {
        Optional<Currencies> currencyTo = currencyRepository.findById(currencies.getCurrenciesTo().toUpperCase());
        Optional<Currencies> currencyFrom = currencyRepository.findById(currencies.getCurrenciesFrom().toUpperCase());

        if (currencyTo.isPresent() && currencyFrom.isPresent()) {
            if (currencies.getAmount() < 0) {
                //TODO throw error that the value you want to convert can't be negative
                return Optional.empty();
            }
            Currencies to = currencyTo.get();
            Currencies from = currencyFrom.get();
            double toValue = to.getValueInEUR();
            double fromValue = from.getValueInEUR();
            Timestamp transactionIdentifier = currencies.getHistory();

            Double result = toValue * currencies.getAmount() / fromValue;

            return Optional.of(result);
        }
        return Optional.empty();
    }
}
