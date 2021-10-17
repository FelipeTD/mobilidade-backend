package com.bot.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bot.entity.Registro;
import com.bot.entity.RegistroList;
import com.bot.entity.RegistroRequest;
import com.bot.entity.Resultado;
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
	
	@GetMapping("/registro/resultados")
	public ResponseEntity<Resultado> findResults(@RequestParam("data") String data) {
		
		Resultado response = service.findResults(data);
		
		ResponseEntity<Resultado> resultado = new ResponseEntity<Resultado>(response, HttpStatus.OK);
		
		return resultado;
		
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
