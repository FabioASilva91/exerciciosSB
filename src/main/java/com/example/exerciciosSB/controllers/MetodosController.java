package com.example.exerciciosSB.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metodos")
public class MetodosController {

	@GetMapping
	public String get() {
		return "Resquisição GET";
	}
	
	@PostMapping
	public String post() {
		return "Resquisição POST";
	}
	
	@PutMapping
	public String put() {
		return "Resquisição PUT";
	}
	
	@PatchMapping
	public String patch() {
		return "Resquisição PATCH";
	}
	
	@DeleteMapping
	public String delete() {
		return "Resquisição DELETE";
	}

}
