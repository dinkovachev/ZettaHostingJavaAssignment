package org.example.zettahostingjavaassignment.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Currencies {
    @Id
    private String name;
    private double valueInEUR;

    public Currencies() {
    }

    public Currencies(String name, double valueInEUR) {
        this.name = name;
        this.valueInEUR = valueInEUR;
    }

    public String getName() {
        return name;
    }

    public void setName(String currencyName) {
        this.name = currencyName;
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
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
