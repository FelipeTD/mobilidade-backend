package com.bot.controller;

import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bot.entity.registro.Registro;
import com.bot.entity.registro.RegistroList;
import com.bot.entity.registro.RegistroRequest;
import com.bot.services.RegistroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RegistroController {
	
	private final RegistroService service;
	
	@GetMapping("/registro")
	public RegistroList findRegistros() {

		RegistroList response = service.findAllRegistros();
        
        return response;
    }
	
	@PostMapping("/registro")
    public ResponseEntity<Registro> saveRegistro(@RequestBody RegistroRequest registro) {
		Registro response = service.salvar(registro);
    	
    	if (Objects.isNull(response)) {
    		return ResponseEntity.badRequest().build();
    	}
    	
    	return ResponseEntity.ok(response);	
    }

}
