package com.bot.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bot.entity.motorista.Motorista;
import com.bot.repository.MotoristaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MotoristaServiceImpl implements MotoristaService {
	
	private final MotoristaRepository repository;
	
	@Override
	public List<Motorista> findAllActiveDrivers() {
		return repository.findDrivers();	
	}
	
	@Override
	public Motorista salvar(Motorista motorista) {
		try {
			Motorista response = repository.save(motorista);
			return response;
		} catch (IllegalArgumentException error) {
			return null;
		}
	}
	
	@Override
	public Motorista updateMotorista(Motorista motorista) {
		Motorista response = repository.save(motorista);
		return response;		
	}
	
	

}
