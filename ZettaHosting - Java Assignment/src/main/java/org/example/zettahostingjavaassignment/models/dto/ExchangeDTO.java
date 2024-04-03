package org.example.zettahostingjavaassignment.models.dto;

import java.util.Map;

public class ExchangeDTO {

    private String convertTo;
    private String convertFrom;
    private double amount;

    public ExchangeDTO() {
    }

    public ExchangeDTO(String convertTo, String convertFrom, double amount) {
        this.convertTo = convertTo;
        this.convertFrom = convertFrom;
        this.amount = amount;
    }

    public String getConvertTo() {
        return convertTo;
    }

    public void setConvertTo(String convertTo) {
        this.convertTo = convertTo;
    }

    public String getConvertFrom() {
        return convertFrom;
    }

    public void setConvertFrom(String convertFrom) {
        this.convertFrom = convertFrom;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
