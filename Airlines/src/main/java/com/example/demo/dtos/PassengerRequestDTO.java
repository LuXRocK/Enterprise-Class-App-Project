package com.example.demo.dtos;

import lombok.Data;

@Data
public class PassengerRequestDTO {
	private String name;
	private String surname;
	private String pesel;
	private String email;
	private int flightId;
}
