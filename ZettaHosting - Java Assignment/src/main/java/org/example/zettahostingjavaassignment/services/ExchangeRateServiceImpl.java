package org.example.zettahostingjavaassignment.services;

import org.example.zettahostingjavaassignment.models.Currencies;
import org.example.zettahostingjavaassignment.models.dto.ExchangeRateDTO;
import org.example.zettahostingjavaassignment.repositories.CurrencyRepository;
import org.example.zettahostingjavaassignment.repositories.ExchangeRateRepository;
import org.example.zettahostingjavaassignment.services.contracts.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private ExchangeRateRepository exchangeRateRepository;
    private CurrencyRepository currencyRepository;

    @Autowired
    public ExchangeRateServiceImpl(ExchangeRateRepository exchangeRateRepository, CurrencyRepository currencyRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Optional<Double> getExchangeRate(ExchangeRateDTO exchangeRateDTO) {
        Optional<Currencies> currencyTo = currencyRepository.findById(exchangeRateDTO.getCurrencyTo().toUpperCase());
        Optional<Currencies> currencyFrom = currencyRepository.findById(exchangeRateDTO.getCurrencyFrom().toUpperCase());

        if (currencyTo.isPresent() && currencyFrom.isPresent()) {
            Currencies to = currencyTo.get();
            Currencies from = currencyFrom.get();
            double toValue = to.getValueInEUR();
            double fromValue = from.getValueInEUR();

            Double result = toValue / fromValue;
            return Optional.of(result);
        }
        return Optional.empty();
    }
}
