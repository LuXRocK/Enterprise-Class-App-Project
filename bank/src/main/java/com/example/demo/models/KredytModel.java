package com.example.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter @Setter
public class KredytModel {
	double amount;	
	double percent;
	int installmentAmount;
	double installment;
}
