package org.example.zettahostingjavaassignment.models.dto;

import java.sql.Timestamp;

public class ConvertedAmountWithTimeStampDTO {
    private double convertedAmount;

    private Timestamp timestamp;

    public ConvertedAmountWithTimeStampDTO() {
    }

    public ConvertedAmountWithTimeStampDTO(double convertedAmount, Timestamp timestamp) {
        this.convertedAmount = convertedAmount;
        this.timestamp = timestamp;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
