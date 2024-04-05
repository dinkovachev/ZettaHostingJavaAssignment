package org.example.zettahostingjavaassignment.repositories;

import org.example.zettahostingjavaassignment.models.Conversion;
import org.example.zettahostingjavaassignment.models.Currencies;
import org.example.zettahostingjavaassignment.models.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface HistoryRepository extends JpaRepository<History, LocalDateTime> {
    Page<Conversion> findAll(Specification<Conversion> spec, Pageable pageable);
}
