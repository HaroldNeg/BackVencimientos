package com.vencimientos.back.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
@RestController
public class HolaController {
	
	@GetMapping
	public String listar(){
		return "Hola mundo Ahora si funciona";
	}
}
