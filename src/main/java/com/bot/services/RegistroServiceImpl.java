package com.bot.services;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bot.entity.cadastro.Cadastro;
import com.bot.entity.registro.Registro;
import com.bot.entity.registro.RegistroList;
import com.bot.entity.registro.RegistroRequest;
import com.bot.repository.CadastroRepository;
import com.bot.repository.RegistroRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegistroServiceImpl implements RegistroService {
	
	private final RegistroRepository repository;
	
	private final CadastroRepository cadastroRepository;
	
	@Override
	public RegistroList findAllRegistros() {
		
		RegistroList response = new RegistroList();
		response.setRegistros(repository.findAllRegistros());
		
		Collections.sort(response.getRegistros(), Comparator.comparing(Registro::getRegistroId));	
		
		return response;
		
	}
	
	@Override 
	public Registro salvar(RegistroRequest registro) {
		
		Optional<Cadastro> cadastro = cadastroRepository.findById(Integer.parseInt(registro.getCadastroId().toString()));
		
		Registro newRegistro = new Registro();
		newRegistro.setCadastro(cadastro.get());
		newRegistro.setValor(registro.getValor());
		
		String[] data = registro.getRegistroData().split(",");
		String dia = data[0].substring(0, 2);
		String mes = data[0].substring(3, 5);
		String ano = data[0].substring(6, 10);
		
		Calendar calendar = new GregorianCalendar(Integer.parseInt(ano), Integer.parseInt(mes) - 1, Integer.parseInt(dia));
		newRegistro.setRegistroData(calendar);
		
		System.out.println(newRegistro.getRegistroData());
		
		try {
			Registro response = repository.save(newRegistro);
			return response;
		} catch (IllegalArgumentException error) {
			return null;
		}
		
	}

}
