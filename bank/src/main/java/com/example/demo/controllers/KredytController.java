package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.KredytModel;
import com.example.demo.services.KredytService;

@Controller
@RequestMapping(path="/kredyt")
public class KredytController {
	@Autowired private KredytService kredytService;
	@GetMapping public @ResponseBody double Calculate(
			@RequestParam double amount) {
		return kredytService.Calculate(amount, 0.1, 12);
	}
}
