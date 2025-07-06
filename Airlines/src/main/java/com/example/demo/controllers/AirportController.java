package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Airport;
import com.example.demo.repositories.AirportRepository;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;

    @GetMapping
    public List<Airport> getAll() {
        return airportRepository.findAll();
    }

    @GetMapping("/{id}")
    public Airport getById(@PathVariable int id) {
        return airportRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Airport add(@RequestBody Airport airport) {
        return airportRepository.save(airport);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        airportRepository.deleteById(id);
    }
}
