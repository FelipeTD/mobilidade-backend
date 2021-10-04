package com.bot.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bot.entity.motorista.Motorista;
import com.bot.entity.motorista.MotoristaList;
import com.bot.repository.MotoristaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MotoristaServiceImpl implements MotoristaService {
	
	private final MotoristaRepository repository;
	
	@Override
	public MotoristaList findAllDrivers() {
		
		MotoristaList response = new MotoristaList();
		
		List<Motorista> motoristas = repository.findDrivers();
		response.setMotoristas(motoristas);
		
		Collections.sort(response.getMotoristas(), Comparator.comparing(Motorista::getDriverId));
		
		return response;	
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
	public MotoristaList updateMotorista(Motorista motorista) {
		repository.save(motorista);
		
		MotoristaList response = this.findAllDrivers();
		
		return response;		
	}
	
	

}
