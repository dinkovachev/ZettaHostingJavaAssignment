package org.example.zettahostingjavaassignment.repositories;

import org.example.zettahostingjavaassignment.models.Conversion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<Conversion, Long> {
    Page<Conversion> findAll(Specification<Conversion> spec, Pageable pageable);
}
