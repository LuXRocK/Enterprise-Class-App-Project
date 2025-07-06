package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
