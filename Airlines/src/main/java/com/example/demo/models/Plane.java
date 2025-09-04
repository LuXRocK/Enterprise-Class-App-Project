package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Plane")
@Data
@NoArgsConstructor
public class Plane {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int seats;

    @Column(nullable = false)
    private int productionYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable = false)
    @JsonBackReference("airline")
    private Airline airline;
}
