package com.example.demo.models;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Component
public class KredytModel {
	private double amount;	
	private double percent;
	private int installmentAmount;
	private double installment;
}
