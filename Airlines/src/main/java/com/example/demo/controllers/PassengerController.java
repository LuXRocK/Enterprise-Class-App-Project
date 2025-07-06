package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Passenger;
import com.example.demo.repositories.PassengerRepository;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping
    public List<Passenger> getAll() {
        return passengerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Passenger getById(@PathVariable int id) {
        return passengerRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Passenger add(@RequestBody Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        passengerRepository.deleteById(id);
    }
}
