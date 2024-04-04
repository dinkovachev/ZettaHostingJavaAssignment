package org.example.zettahostingjavaassignment.repositories;

import org.example.zettahostingjavaassignment.models.Currencies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currencies, String> {


}
