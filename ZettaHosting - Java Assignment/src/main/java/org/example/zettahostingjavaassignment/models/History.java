package org.example.zettahostingjavaassignment.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class History {

    @Id
    @JsonIgnore
    private int id;
    private LocalDateTime transactionHistory;

    public History() {
    }

    public History(LocalDateTime transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public LocalDateTime getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(LocalDateTime transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
}
