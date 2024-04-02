package org.example.zettahostingjavaassignment.repositories;

import org.example.zettahostingjavaassignment.models.Exchanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchanges, Long>{

}
