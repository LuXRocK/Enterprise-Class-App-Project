package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private Airline airline;
}
