package com.bot.services;

import java.util.Collections;
import java.util.Comparator;

import org.springframework.stereotype.Component;

import com.bot.entity.cadastro.Cadastro;
import com.bot.entity.cadastro.CadastroList;
import com.bot.repository.CadastroRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastroServiceImpl implements CadastroService {
	
	private final CadastroRepository repository;
	
	@Override
	public CadastroList findCadastros() {
		
		CadastroList response = new CadastroList();
		response.setCadastros(repository.findCadastros());
		
		Collections.sort(response.getCadastros(), Comparator.comparing(Cadastro::getCadastroId));		
		
		return response;
		
	}

}
