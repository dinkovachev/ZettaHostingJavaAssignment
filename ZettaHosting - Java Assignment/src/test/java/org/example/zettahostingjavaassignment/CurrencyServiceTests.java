package org.example.zettahostingjavaassignment;


import org.example.zettahostingjavaassignment.models.Currencies;
import org.example.zettahostingjavaassignment.repositories.CurrencyRepository;
import org.example.zettahostingjavaassignment.services.CurrencyServiceImpl;
import org.example.zettahostingjavaassignment.services.contracts.CurrencyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CurrencyServiceTests {

    @Mock
    private CurrencyRepository mockRepository;

    private CurrencyService currencyService;

    @BeforeEach
    public void setup() {
        currencyService = new CurrencyServiceImpl(mockRepository);
    }

    @Test
    public void getAll_Should_Return_EmptyListWithCurrencies() {
        //Act, Arrange
        Mockito.when(mockRepository.findAll()).thenReturn(Arrays.asList());
        List<Currencies> currenciesList = currencyService.getAllCurrencies();

        //Assert
        Assertions.assertTrue(currenciesList.isEmpty());
    }

    @Test
    public void getAll_Should_Return_AllCurrenciesSorted() {
        //Act, Arrange
        Currencies currenciesEUR = new Currencies("EUR", 1);
        Currencies currenciesUSD = new Currencies("USD", 2);
        Currencies currenciesBGN = new Currencies("BGN", 3.3);

        Mockito.when(mockRepository.findAll()).thenReturn(Arrays.asList(currenciesEUR, currenciesBGN, currenciesUSD));

        List<Currencies> currenciesList = currencyService.getAllCurrencies();
        Assertions.assertFalse(currenciesList.isEmpty());

        //Assert
        Assertions.assertEquals(currenciesList.get(0).getCurrencyName(), currenciesBGN.getCurrencyName());
        Assertions.assertEquals(currenciesList.get(1).getCurrencyName(), currenciesEUR.getCurrencyName());
        Assertions.assertEquals(currenciesList.get(2).getCurrencyName(), currenciesUSD.getCurrencyName());
    }
}
