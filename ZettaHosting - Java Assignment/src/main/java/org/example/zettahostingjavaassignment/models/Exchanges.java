package org.example.zettahostingjavaassignment.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Entity
//@Table(name = "exchanges")
public class Exchanges {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private long id;
//    @Column(name = "currencyFrom")
    private String currenciesFrom;
//    @Column(name = "currencyTo")
    private String currenciesTo;
//    @Column(name = "history")
    private LocalDateTime history;
//    @Column(name = "amount")
    private double amount;

    public Exchanges() {
    }

    public Exchanges(long id, String currenciesFrom, String currenciesTo, LocalDateTime history, double amount) {
        this.id = id;
        this.currenciesFrom = currenciesFrom;
        this.currenciesTo = currenciesTo;
        this.history = history;
        this.amount = amount;
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

    public String getCurrenciesTo() {
        return currenciesTo;
    }

    public void setCurrenciesTo(String currenciesTo) {
        this.currenciesTo = currenciesTo;
    }

    public LocalDateTime getHistory() {
        return history;
    }

    public void setHistory(LocalDateTime history) {
        this.history = history;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}


