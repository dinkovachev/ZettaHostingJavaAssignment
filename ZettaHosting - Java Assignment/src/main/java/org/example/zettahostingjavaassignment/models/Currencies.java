package org.example.zettahostingjavaassignment.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
//@Table(name = "currencies")
public class Currencies {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "name")
    private String currencyName;
//    @Column(name = "valueInBGN")
    private double valueInEUR;

    public Currencies() {
    }

    public Currencies(String currencyName, double valueInEUR) {
        this.currencyName = currencyName;
        this.valueInEUR = valueInEUR;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getValueInEUR() {
        return valueInEUR;
    }

    public void setValueInEUR(double valueInBGN) {
        this.valueInEUR = valueInBGN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currencies that = (Currencies) o;
        return Objects.equals(currencyName, that.currencyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyName);
    }
}
