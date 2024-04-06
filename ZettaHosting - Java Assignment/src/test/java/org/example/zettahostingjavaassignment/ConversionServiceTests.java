package org.example.zettahostingjavaassignment;

import org.example.zettahostingjavaassignment.models.Conversion;
import org.example.zettahostingjavaassignment.models.Currencies;
import org.example.zettahostingjavaassignment.repositories.ConversionRepository;
import org.example.zettahostingjavaassignment.repositories.CurrencyRepository;
import org.example.zettahostingjavaassignment.services.ConversionServiceImpl;
import org.example.zettahostingjavaassignment.services.CurrencyServiceImpl;
import org.example.zettahostingjavaassignment.services.contracts.ConversionService;
import org.example.zettahostingjavaassignment.services.contracts.CurrencyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ConversionServiceTests {

    @Mock
    private ConversionRepository mockConversionRepository;
    @Mock
    private CurrencyRepository  mockCurrencyRepository;
    private ConversionService conversionService;

    @BeforeEach
    public void setup() {
        conversionService = new ConversionServiceImpl(mockConversionRepository, mockCurrencyRepository);
    }

    @Test
    public void convert_Should_Return_Empty_WhenNegativeValue() {
        //Act, Arrange
        Currencies currenciesEUR = new Currencies("EUR", 1);
        Currencies currenciesUSD = new Currencies("USD", 2);

        Mockito.when(mockCurrencyRepository.findById("EUR")).thenReturn(Optional.of(currenciesEUR));
        Mockito.when(mockCurrencyRepository.findById("USD")).thenReturn(Optional.of(currenciesUSD));

        Conversion conversionCurrency = new Conversion(1L,
                "EUR",
                "USD",
                LocalDateTime.now(),
                -10);
        Optional<Double> result = conversionService.convert(conversionCurrency);

        //Assert
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void convert_Should_Return_Empty_WhenCurrencyDoesntExists() {
        //Act, Arrange
        Currencies currenciesUSD = new Currencies("USD", 1);

        Mockito.when(mockCurrencyRepository.findById("EUR")).thenReturn(Optional.empty());
        Mockito.when(mockCurrencyRepository.findById("USD")).thenReturn(Optional.of(currenciesUSD));

        Conversion conversionCurrency = new Conversion(1L,
                "EUR",
                "USD",
                LocalDateTime.now(),
                0);
        Optional<Double> result = conversionService.convert(conversionCurrency);

        //Assert
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void convert_Should_Return_Amount_WhenValueIsPositive() {
        //Act, Arrange
        Currencies currenciesEUR = new Currencies("EUR", 1);
        Currencies currenciesUSD = new Currencies("USD", 1.15795);

        Mockito.when(mockCurrencyRepository.findById("EUR")).thenReturn(Optional.of(currenciesEUR));
        Mockito.when(mockCurrencyRepository.findById("USD")).thenReturn(Optional.of(currenciesUSD));

        Conversion conversionCurrency = new Conversion(1L,
                "EUR",
                "USD",
                LocalDateTime.now(),
                10);
        Optional<Double> result = conversionService.convert(conversionCurrency);

        //Assert
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isPresent());
    }

}
