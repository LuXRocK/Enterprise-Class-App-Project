package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Airline;
import com.example.demo.repositories.AirlineRepository;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineController {

    @Autowired
    private AirlineRepository airlineRepository;

    @GetMapping
    public List<Airline> getAll() {
        return airlineRepository.findAll();
    }

    @GetMapping("/{id}")
    public Airline getById(@PathVariable int id) {
        return airlineRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Airline add(@RequestBody Airline airline) {
        return airlineRepository.save(airline);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        airlineRepository.deleteById(id);
    }
}
