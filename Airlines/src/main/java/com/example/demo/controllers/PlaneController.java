package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.*;
import com.example.demo.repositories.*;
import com.example.demo.dtos.PlaneRequestDTO;

import java.util.List;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    @Autowired
    private PlaneRepository planeRepository;
    
    @Autowired
    private AirlineRepository airlineRepository;

    @GetMapping
    public List<Plane> getAll() {
        return planeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Plane getById(@PathVariable int id) {
        return planeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Plane add(@RequestBody PlaneRequestDTO dto) {
    	Airline airline = airlineRepository.findById(dto.getAirlineId())
    			.orElseThrow(() -> new RuntimeException("Airline not found"));
    	Plane plane = new Plane();
    	plane.setModel(dto.getModel());
    	plane.setSeats(dto.getSeats());
    	plane.setProductionYear(dto.getProductionYear());
    	plane.setAirline(airline);
        return planeRepository.save(plane);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        planeRepository.deleteById(id);
    }
}
