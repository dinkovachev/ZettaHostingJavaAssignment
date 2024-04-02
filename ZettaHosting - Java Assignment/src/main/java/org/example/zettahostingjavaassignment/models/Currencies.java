package org.example.zettahostingjavaassignment.models;

import jakarta.persistence.*;
import org.example.zettahostingjavaassignment.models.enums.CurrenciesEnums;

public class Currencies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private CurrenciesEnums currenciesFrom;
    @Enumerated(EnumType.STRING)
    private CurrenciesEnums currenciesTo;
    private double exchangeRate;

    public Currencies() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CurrenciesEnums getCurrenciesFrom() {
        return currenciesFrom;
    }

    public void setCurrenciesFrom(CurrenciesEnums currenciesFrom) {
        this.currenciesFrom = currenciesFrom;
    }

    public CurrenciesEnums getCurrenciesTo() {
        return currenciesTo;
    }

    public void setCurrenciesTo(CurrenciesEnums currenciesTo) {
        this.currenciesTo = currenciesTo;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
