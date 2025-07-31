package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.*;
import com.example.demo.repositories.*;
import com.example.demo.dtos.FlightRequestDTO;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;
    
    @Autowired
    private AirportRepository airportRepository;
    
    @Autowired
    private AirlineRepository airlineRepository;
    
    @Autowired
    private PlaneRepository planeRepository;

    @GetMapping
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @GetMapping("/{id}")
    public Flight getById(@PathVariable int id) {
        return flightRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Flight add(@RequestBody FlightRequestDTO dto) {
    	Flight flight = new Flight();
    	
    	flight.setStatus(Flight.FlightStatus.valueOf(dto.getStatus()));
    	flight.setCode(dto.getCode());
    	flight.setDepartureTime(dto.getDepartureTime());
    	flight.setArrivalTime(dto.getArrivalTime());
    	
    	flight.setDepartureAirport(airportRepository.findById(dto.getDepartureAirportId())
    	    .orElseThrow(() -> new RuntimeException("Departure airport not found")));
    	flight.setArrivalAirport(airportRepository.findById(dto.getArrivalAirportId())
    	    .orElseThrow(() -> new RuntimeException("Arrival airport not found")));
    	flight.setAirline(airlineRepository.findById(dto.getAirlineId())
    	    .orElseThrow(() -> new RuntimeException("Airline not found")));
    	
    	if(dto.getPlaneId() != null) {
    		flight.setPlane(planeRepository.findById(dto.getPlaneId())
    				.orElseThrow(() -> new RuntimeException("Plane not found")));
    	}
    	
    	return flightRepository.save(flight);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        flightRepository.deleteById(id);
    }
}
