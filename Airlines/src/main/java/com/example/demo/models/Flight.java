package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Flight")
@Data
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FlightStatus status;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(nullable = false)
    private LocalDateTime arrivalTime;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id", nullable = false)
    @JsonBackReference("departure")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    @JsonBackReference("arrival")
    private Airport arrivalAirport;

    @ManyToOne
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;

    @ManyToOne
    @JoinColumn(name = "plane_id", nullable = true)
    private Plane plane;

    @ManyToMany(mappedBy = "flights")
    @JsonIgnore
    private List<Passenger> passengers;

    public enum FlightStatus {
        SCHEDULED, BOARDING, DEPARTED, IN_AIR, LANDED,
        CANCELLED, DELAYED, DIVERTED, UNKNOWN
    }
}
