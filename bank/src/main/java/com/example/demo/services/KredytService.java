package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.models.KredytModel;

@Service
public class KredytService {
	public double Calculate(double amount, double percent, int installmentAmount) {
		double m = 1 - 1 / Math.pow(1.0 + percent / 12, installmentAmount);
		double installment = amount * (percent / 12) / m;
		return installment;
	}
}
