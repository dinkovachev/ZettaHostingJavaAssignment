package org.example.zettahostingjavaassignment.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class Conversion {
    @Id
    private long id;
    private String currenciesFrom;
    private String currenciesTo;
    private Timestamp history;
    private double amount;

    public Conversion() {
    }

    public Conversion(long id, String currenciesFrom, String currenciesTo, Timestamp history, double amount) {
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

    public Timestamp getHistory() {
        return history;
    }

    public void setHistory(Timestamp history) {
        this.history = history;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}


