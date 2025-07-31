package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Airport")
@Data
@NoArgsConstructor
public class Airport {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "departureAirport")
    @JsonManagedReference("departure")
    private List<Flight> departures;

    @OneToMany(mappedBy = "arrivalAirport")
    @JsonManagedReference("arrival")
    private List<Flight> arrivals;
}
