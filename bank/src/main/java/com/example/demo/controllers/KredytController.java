package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.KredytModel;
import com.example.demo.services.KredytService;

@RestController
@RequestMapping(path="/kredyt")
public class KredytController {
	
    @Autowired
    private KredytService kredytService;
    
    @Autowired
    private KredytModel kredytModel;
	
	@PostMapping("/kredyt3")
	public KredytModel getKredyt3(
	@RequestBody KredytModel kredyt) {
	System.out.println(
	kredyt.getAmount()+"," +kredyt.getPercent()+","
	+kredyt.getInstallmentAmount()+"," + Math.round(kredyt.getInstallment()*100) / 100.0);
	
	double rata = kredytService.Calculate(kredyt.getAmount(), kredyt.getPercent(), kredyt.getInstallmentAmount());
    kredyt.setInstallment(rata);
    
	return kredyt;
	}
}
