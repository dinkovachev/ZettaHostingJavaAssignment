package org.example.zettahostingjavaassignment.controllers;

import org.example.zettahostingjavaassignment.models.Conversion;
import org.example.zettahostingjavaassignment.services.contracts.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryRestController {

    private HistoryService historyService;

    @Autowired
    public HistoryRestController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public ResponseEntity<List<Conversion>> getConversionHistory(
            @RequestParam(value = "transactionDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime transactionDate,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size){
        Page<Conversion> conversions = historyService.getConversionHistory(transactionDate, PageRequest.of(page, size));
        return ResponseEntity.ok()
                .header("X-total-count", String.valueOf(conversions.getTotalElements()))
                .header("X-total-pages", String.valueOf(conversions.getTotalPages()))
                .body(conversions.getContent());
    }

}
