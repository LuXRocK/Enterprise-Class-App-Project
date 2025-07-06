package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Plane;
import com.example.demo.repositories.PlaneRepository;

import java.util.List;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    @Autowired
    private PlaneRepository planeRepository;

    @GetMapping
    public List<Plane> getAll() {
        return planeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Plane getById(@PathVariable int id) {
        return planeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Plane add(@RequestBody Plane plane) {
        return planeRepository.save(plane);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        planeRepository.deleteById(id);
    }
}
