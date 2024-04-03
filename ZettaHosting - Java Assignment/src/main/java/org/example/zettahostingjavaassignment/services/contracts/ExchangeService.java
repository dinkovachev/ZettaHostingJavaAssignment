package org.example.zettahostingjavaassignment.services.contracts;

import org.example.zettahostingjavaassignment.models.Exchanges;

import java.util.Optional;

public interface ExchangeService {

    Optional<Double> convert(Exchanges currencies);
}
