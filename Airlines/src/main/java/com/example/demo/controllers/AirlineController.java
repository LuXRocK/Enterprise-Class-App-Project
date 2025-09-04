package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.*;
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
    
//    @GetMapping("/{id}/flights")
//    public List<Flight> getFlightsByAirline(@PathVariable int id){
//    	Airline airline = airlineRepository.findById(id).orElseThrow();
//    	return airline.getFlights();
//    }
//    
    @GetMapping("/{id}/planes")
    public List<Plane> getPlanesByAirline(@PathVariable int id){
    	Airline airline = airlineRepository.findById(id).orElseThrow();
    	return airline.getPlanes();
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
