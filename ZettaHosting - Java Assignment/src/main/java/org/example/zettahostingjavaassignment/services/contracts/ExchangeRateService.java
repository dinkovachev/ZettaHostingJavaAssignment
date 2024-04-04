package org.example.zettahostingjavaassignment.services.contracts;

import org.example.zettahostingjavaassignment.models.dto.ExchangeRateDTO;

import java.util.Optional;

public interface ExchangeRateService {

    Optional<Double> getExchangeRate(ExchangeRateDTO exchangeRateDTO);


}
