package org.example.zettahostingjavaassignment.models.dto;

import java.time.LocalDateTime;

public class ConvertedAmountWithTimeStampDTO {
    private double convertedAmount;

    private LocalDateTime timestamp;

    public ConvertedAmountWithTimeStampDTO() {
    }

    public ConvertedAmountWithTimeStampDTO(double convertedAmount, LocalDateTime timestamp) {
        this.convertedAmount = convertedAmount;
        this.timestamp = timestamp;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
