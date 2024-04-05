package org.example.zettahostingjavaassignment.services.contracts;

import org.example.zettahostingjavaassignment.models.Conversion;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ConversionService {

    Optional<Double> convert(Conversion currencies);

    List<Conversion> findAll();
}
