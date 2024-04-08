package org.example.zettahostingjavaassignment.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ExchangeRate {
    @Id
    @JsonIgnore
    private int id;
    private String currencyFrom;
    private String currencyTo;

    public ExchangeRate() {
    }

    public ExchangeRate(String currencyFrom, String currencyTo) {

        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }
}
