package org.example.zettahostingjavaassignment.services.contracts;

import org.example.zettahostingjavaassignment.models.Currencies;

import java.util.List;
import java.util.Optional;


public interface CurrencyService {

    List<Currencies> getAllCurrencies();

    Optional<Currencies> getByName(String name);


}
