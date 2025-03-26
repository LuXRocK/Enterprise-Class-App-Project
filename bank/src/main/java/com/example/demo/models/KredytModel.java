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
	
//	public double Calculate(double amount, double percent, int installmentAmount) {
//		this.amount = amount;
//		this.percent = percent;
//		this.installmentAmount = installmentAmount;
//		double m = 1 - 1 / Math.pow(1.0 + percent / 12, installmentAmount);
//		this.installment = amount * (percent / 12) / m;
//		return installment;
//	}
	
	public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public double getPercent() { return percent; }
    public void setPercent(double percent) { this.percent = percent; }

    public int getInstallmentAmount() { return installmentAmount; }
    public void setInstallmentAmount(int installmentAmount) { this.installmentAmount = installmentAmount; }
    
    public double getInstallment() { return installment; }
    public void setInstallment(double installment) { this.installment = installment; }
}
