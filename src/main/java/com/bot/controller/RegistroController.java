package com.bot.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bot.registros.Registros;
import com.bot.services.RegistroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RegistroController {
	
	private final RegistroService service;
	
	@GetMapping("/registros")
	public List<Registros> findRegistros() {

        List<Registros> registros = (ArrayList<Registros>) service.findRegistrosByIdAndDate("1", "2021-09-13", "2021-09-20");

        return registros;
    }
	
	@GetMapping("/registros/total")
	public String findTotalByRegistro() {
		
		Double total = service.findTotalByRegistro("1", "2021-09-13", "2021-09-20");
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		return df.format(total);
		
	}

}
