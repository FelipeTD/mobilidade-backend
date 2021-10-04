package com.bot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bot.entity.cadastro.CadastroList;
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

}
