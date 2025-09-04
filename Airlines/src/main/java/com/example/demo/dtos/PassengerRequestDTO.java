package com.example.demo.dtos;

import java.util.List;

import lombok.Data;

@Data
public class PassengerRequestDTO {
	private String name;
	private String surname;
	private String email;
	private List<Integer> flightIds;
}
