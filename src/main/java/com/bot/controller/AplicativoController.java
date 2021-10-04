package com.bot.controller;

import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bot.entity.aplicativo.Aplicativo;
import com.bot.entity.aplicativo.AplicativoList;
import com.bot.services.AplicativoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AplicativoController {
	
	private final AplicativoService service;
	
	@GetMapping("/aplicativo/show")
    public AplicativoList findAplicativos() {
		AplicativoList response = service.findAllActiveAplicativos();

        return response;
    }
	
	@PostMapping("/aplicativo/salvar")
    public ResponseEntity<Aplicativo> saveAplicativo(@RequestBody Aplicativo aplicativo) {
		Aplicativo response = service.salvar(aplicativo);
    	
    	if (Objects.isNull(response)) {
    		return ResponseEntity.badRequest().build();
    	}
    	
    	return ResponseEntity.ok(response);	
    }
	
	@PostMapping("/aplicativo/status")
    public AplicativoList updateAplicativo(@RequestBody Aplicativo aplicativo) {
		AplicativoList response = service.updateAplicativo(aplicativo);
    	
    	return response;
    }

}
