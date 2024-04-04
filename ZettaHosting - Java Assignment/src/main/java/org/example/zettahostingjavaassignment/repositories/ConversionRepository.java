package org.example.zettahostingjavaassignment.repositories;

import org.example.zettahostingjavaassignment.models.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, Long>{

}
