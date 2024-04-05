package org.example.zettahostingjavaassignment.services;

import org.example.zettahostingjavaassignment.models.Conversion;
import org.example.zettahostingjavaassignment.repositories.HistoryRepository;
import org.example.zettahostingjavaassignment.services.contracts.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public Page<Conversion> getConversionHistory(Timestamp transactionDate, Pageable pageable) {
        Specification<Conversion> spec = constructQuery(transactionDate);
        return historyRepository.findAll(spec, pageable);
    }

    private Specification<Conversion> constructQuery(Timestamp transactionDate) {
        return Specification.where(transactionDate != null ? byTransactionDate(transactionDate) : null);
    }

    public static Specification<Conversion> byTransactionDate(Timestamp transactionDate) {
        return (root, query, builder) -> builder.equal(root.get("history").as(Timestamp.class),
                transactionDate);
    }
}

