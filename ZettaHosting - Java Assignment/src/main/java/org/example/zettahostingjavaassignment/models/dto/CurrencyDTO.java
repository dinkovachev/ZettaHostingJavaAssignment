package org.example.zettahostingjavaassignment.models.dto;

import java.util.Map;

public class CurrencyDTO {

    private boolean success;
    private long timeStamp;
    private String base;
    private String date;
    private Map<String, Double> rates;

    public CurrencyDTO() {
    }

    public CurrencyDTO(boolean success, long timeStamp, String base, String date, Map<String, Double> rates) {
        this.success = success;
        this.timeStamp = timeStamp;
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
