package com.bot.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bot.registros.Registros;
import com.bot.repository.RegistroRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegistroServiceImpl implements RegistroService {
	
	private final RegistroRepository repository;

	@Override
	public List<Registros> findRegistrosByIdAndDate(String cadastroId, String startDate, String finalDate) {
		
		List<Registros> registros = repository.findRegistrosByIdAndDate(cadastroId, startDate, finalDate);
		
		return registros;
	}
	
	@Override
	public Double findTotalByRegistro(String cadastroId, String startDate, String finalDate) {
		
		List<Registros> registros = repository.findRegistrosByIdAndDate(cadastroId, startDate, finalDate);
		
		Double total = Double.valueOf(0);
		
		for (Registros registro : registros) {
			total += registro.getValor();
		}
		
		return total;
		
	}

}
