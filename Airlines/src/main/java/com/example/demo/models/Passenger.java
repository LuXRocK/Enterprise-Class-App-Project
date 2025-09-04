package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Passenger")
@Data
@NoArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;

    @ManyToMany
    @JoinTable(
    		name = "passenger_flight",
    		joinColumns = @JoinColumn(name = "passenger_id"),
    		inverseJoinColumns = @JoinColumn(name = "flight_id")
    		)
//    @JsonIgnore
    private List<Flight> flights;
}
