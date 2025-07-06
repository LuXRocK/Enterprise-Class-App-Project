package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Plane;

public interface PlaneRepository extends JpaRepository<Plane, Integer> {
}
