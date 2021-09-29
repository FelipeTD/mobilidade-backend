package com.bot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bot.entity.motorista.Motorista;
import com.bot.services.MotoristaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MotoristaController {
	
    private final MotoristaService service;

    @GetMapping("/motorista/show")
    public List<Motorista> findMotoristas() {
        List<Motorista> motoristas = (ArrayList<Motorista>) service.findAllActiveDrivers();

        return motoristas;
    }
    
    @PostMapping("/motorista/salvar")
    public ResponseEntity<Motorista> saveMotorista(@RequestBody Motorista motorista) {
    	Motorista response = service.salvar(motorista);
    	
    	if (Objects.isNull(response)) {
    		return ResponseEntity.badRequest().build();
    	}
    	
    	return ResponseEntity.ok(response);	
    }
    
    @PostMapping("/motorista/status")
    public ResponseEntity<Motorista> updateMotorista(@RequestBody Motorista motorista) {
    	Motorista response = service.updateMotorista(motorista);
    	
    	if (Objects.isNull(response)) {
    		return ResponseEntity.badRequest().build();
    	}
    	
    	return ResponseEntity.ok(response);	
    }

}
