package com.bot.controller;

import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bot.entity.Cadastro;
import com.bot.entity.CadastroList;
import com.bot.services.CadastroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CadastroController {
	
    private final CadastroService service;

    @GetMapping("/cadastro/show")
    public CadastroList findMotoristas() {
    	CadastroList cadastros = service.findCadastros();
    	
        return cadastros;
    }
    
    @PostMapping("/cadastro/salvar")
    public ResponseEntity<Cadastro> saveCadastro(@RequestBody Cadastro cadastro) {
		Cadastro response = service.salvar(cadastro);
    	
    	if (Objects.isNull(response)) {
    		return ResponseEntity.badRequest().build();
    	}
    	
    	return ResponseEntity.ok(response);	
    }

}
