package com.bot.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.bot.entity.aplicativo.Aplicativo;
import com.bot.entity.aplicativo.AplicativoList;
import com.bot.repository.AplicativoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AplicativoServiceImpl implements AplicativoService {
	
	private final AplicativoRepository repository;
	
	@Override
	public AplicativoList findAllAplicativos() {
		
		AplicativoList response = new AplicativoList();
		response.setAplicativos(repository.findAplicativos());
		
		Collections.sort(response.getAplicativos(), Comparator.comparing(Aplicativo::getAplicativoId));
		
		return response;
	}
	
	@Override
	public AplicativoList findAllActiveAplicativos() {
		
		AplicativoList response = new AplicativoList();
		response.setAplicativos(repository.findAllActiveAplicativos());
		
		Collections.sort(response.getAplicativos(), Comparator.comparing(Aplicativo::getAplicativoId));
		
		return response;
	}

	@Override
	public Aplicativo salvar(Aplicativo aplicativo) {
		try {
			Aplicativo response = repository.save(aplicativo);
			return response;
		} catch (IllegalArgumentException error) {
			return null;
		}
	}

	@Override
	public AplicativoList updateAplicativo(Aplicativo aplicativo) {
		Aplicativo response = repository.save(aplicativo);
		
		if (!Objects.isNull(response)) {
			return this.findAllAplicativos();	
		} else {
			return null;
		}	
	}

}
