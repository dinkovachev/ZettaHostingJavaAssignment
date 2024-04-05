package org.example.zettahostingjavaassignment.services.contracts;

import org.example.zettahostingjavaassignment.models.ExchangeRate;

import java.util.Optional;

public interface ExchangeRateService {

    Optional<Double> getExchangeRate(ExchangeRate exchangeRate);


}
