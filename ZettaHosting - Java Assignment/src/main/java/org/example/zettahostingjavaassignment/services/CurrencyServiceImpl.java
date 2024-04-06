package org.example.zettahostingjavaassignment.services;

import jakarta.persistence.EntityNotFoundException;
import org.example.zettahostingjavaassignment.models.Currencies;
import org.example.zettahostingjavaassignment.repositories.CurrencyRepository;
import org.example.zettahostingjavaassignment.services.contracts.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    public static final String NO_SUCH_CURRENCY_ERROR = "No such currency";
    private CurrencyRepository currencyRepository;


    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {

        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<Currencies> getAllCurrencies() {
        List<Currencies> currenciesList = currencyRepository.findAll();
        currencyRepository.saveAll(currenciesList);
        currenciesList.sort(Comparator.comparing(Currencies::getCurrencyName));
        return currenciesList;
    }

    @Override
    public Optional<Currencies> getByName(String name) {
        try {
            return currencyRepository.findById(name);
        } catch (EntityNotFoundException e){
            throw new EntityNotFoundException(NO_SUCH_CURRENCY_ERROR);
        }
    }
}
