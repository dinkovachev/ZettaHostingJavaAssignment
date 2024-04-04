package org.example.zettahostingjavaassignment.services;

import org.example.zettahostingjavaassignment.models.Currencies;
import org.example.zettahostingjavaassignment.models.Exchanges;
import org.example.zettahostingjavaassignment.repositories.CurrencyRepository;
import org.example.zettahostingjavaassignment.repositories.ExchangeRepository;
import org.example.zettahostingjavaassignment.services.contracts.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeRepository exchangeRepository;

    private final CurrencyRepository currencyRepository;

    @Autowired
    public ExchangeServiceImpl(ExchangeRepository exchangeRepository, CurrencyRepository currencyRepository) {
        this.exchangeRepository = exchangeRepository;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Optional<Double> convert(Exchanges currencies) {
        Optional<Currencies> currencyTo = currencyRepository.findById(currencies.getCurrenciesTo().toUpperCase());
        Optional<Currencies> currencyFrom = currencyRepository.findById(currencies.getCurrenciesFrom().toUpperCase());

        if (currencyTo.isPresent() && currencyFrom.isPresent()){
            if(currencies.getAmount()<0){
                //TODO throw error that the value you want to convert can't be negative
                return Optional.empty();
            }
            Currencies to = currencyTo.get();
            Currencies from = currencyFrom.get();
            double toValue = to.getValueInEUR();
            double fromValue = from.getValueInEUR();

            Double result = toValue * currencies.getAmount() / fromValue;
            return Optional.of(result);
        }
        return Optional.empty();
    }
}
