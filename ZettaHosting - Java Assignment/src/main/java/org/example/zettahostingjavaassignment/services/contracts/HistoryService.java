package org.example.zettahostingjavaassignment.services.contracts;

import org.example.zettahostingjavaassignment.models.Conversion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface HistoryService {

    Page<Conversion> getConversionHistory(LocalDateTime transactionDate, Pageable pageable);
}
