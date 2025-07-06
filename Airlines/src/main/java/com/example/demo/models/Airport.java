package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private List<Flight> departures;

    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flight> arrivals;
}
