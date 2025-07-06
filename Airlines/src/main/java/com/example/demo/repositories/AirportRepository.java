package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Airport;

public interface AirportRepository extends JpaRepository<Airport, Integer> {
}
