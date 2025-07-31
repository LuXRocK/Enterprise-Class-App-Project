package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.PassengerRequestDTO;
import com.example.demo.models.*;
import com.example.demo.repositories.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerRepository passengerRepository;
    
    @Autowired
    private FlightRepository flightRepository;

    @GetMapping
    public List<Passenger> getAll() {
        return passengerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Passenger getById(@PathVariable int id) {
        return passengerRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Passenger add(@RequestBody PassengerRequestDTO dto) {
    	Flight flight = flightRepository.findById(dto.getFlightId())
    			.orElseThrow(() -> new RuntimeException("Flight not found"));
    	
    	Passenger passenger = new Passenger();
    	passenger.setName(dto.getName());
    	passenger.setSurname(dto.getSurname());
    	passenger.setPesel(dto.getPesel());
    	passenger.setEmail(dto.getEmail());
    	passenger.setFlight(flight);
        return passengerRepository.save(passenger);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        passengerRepository.deleteById(id);
    }
}
