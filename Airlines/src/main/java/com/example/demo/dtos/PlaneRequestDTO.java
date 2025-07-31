package com.example.demo.dtos;

import lombok.Data;

@Data
public class PlaneRequestDTO {
	private String model;
	private int seats;
	private int productionYear;
	private int airlineId;
}
