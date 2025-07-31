package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Airline")
@Data
@NoArgsConstructor
public class Airline {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "airline")
    @JsonIgnore
    private List<Flight> flights;
    
    @OneToMany(mappedBy = "airline")
    @JsonBackReference("plane")
    private List<Plane> planes;
}

