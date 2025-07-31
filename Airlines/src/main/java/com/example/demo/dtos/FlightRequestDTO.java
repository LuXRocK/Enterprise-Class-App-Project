package com.example.demo.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightRequestDTO {
    private String status;
    private String code;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int departureAirportId;
    private int arrivalAirportId;
    private int airlineId;
    private Integer planeId;
    private List<String> passengers;
}