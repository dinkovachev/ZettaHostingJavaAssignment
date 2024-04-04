package org.example.zettahostingjavaassignment.repositories;

import org.example.zettahostingjavaassignment.models.dto.ExchangeRateDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateDTO, Double> {

}
