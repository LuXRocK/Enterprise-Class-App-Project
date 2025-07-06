package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Flight;
import com.example.demo.repositories.FlightRepository;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @GetMapping("/{id}")
    public Flight getById(@PathVariable int id) {
        return flightRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Flight add(@RequestBody Flight flight) {
        return flightRepository.save(flight);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        flightRepository.deleteById(id);
    }
}
