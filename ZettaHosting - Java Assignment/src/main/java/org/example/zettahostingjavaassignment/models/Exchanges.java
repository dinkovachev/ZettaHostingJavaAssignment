package org.example.zettahostingjavaassignment.models;

import jakarta.persistence.*;

import java.time.format.DateTimeFormatter;

public class Exchanges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "currencyFrom")
    private String currenciesFrom;

    @Column(name = "amountFrom")
    private double amountFrom;

    @Enumerated(EnumType.STRING)
    @Column(name = "currencyTo")
    private String currenciesTo;

    @Column(name = "amountTo")
    private double amountTo;

    @Column(name = "history")
    private DateTimeFormatter history;

    public Exchanges() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCurrenciesFrom() {
        return currenciesFrom;
    }

    public void setCurrenciesFrom(String currenciesFrom) {
        this.currenciesFrom = currenciesFrom;
    }

    public double getAmountFrom() {
        return amountFrom;
    }

    public void setAmountFrom(double amountFrom) {
        this.amountFrom = amountFrom;
    }

    public String getCurrenciesTo() {
        return currenciesTo;
    }

    public void setCurrenciesTo(String currenciesTo) {
        this.currenciesTo = currenciesTo;
    }

    public double getAmountTo() {
        return amountTo;
    }

    public void setAmountTo(double amountTo) {
        this.amountTo = amountTo;
    }

    public DateTimeFormatter getHistory() {
        return history;
    }

    public void setHistory(DateTimeFormatter history) {
        this.history = history;
    }
}
