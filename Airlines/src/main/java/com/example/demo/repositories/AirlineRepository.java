package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {
}
