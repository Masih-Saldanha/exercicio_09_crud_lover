package com.crudlover.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudlover.api.model.Cars;

public interface CarsRepository extends JpaRepository<Cars, Long> {
    
}
