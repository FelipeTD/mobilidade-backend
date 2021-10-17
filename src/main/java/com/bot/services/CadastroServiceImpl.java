package com.bot.services;

import java.util.Collections;
import java.util.Comparator;

import org.springframework.stereotype.Component;

import com.bot.entity.Cadastro;
import com.bot.entity.CadastroList;
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
		
		Collections.sort(response.getCadastros(), Comparator.comparing(Cadastro::getNumeroAplicativo));		
		
		return response;
		
	}
	
	@Override 
	public Cadastro salvar(Cadastro cadastro) {
		try {
			Cadastro response = repository.save(cadastro);
			return response;
		} catch (IllegalArgumentException error) {
			return null;
		}
		
	}

}
