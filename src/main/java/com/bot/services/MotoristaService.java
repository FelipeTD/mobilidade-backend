package com.bot.services;

import java.util.List;

import com.bot.entity.motorista.Motorista;

public interface MotoristaService {
	
	List<Motorista> findAllActiveDrivers();
	
	Motorista salvar(Motorista motorista);
	
	Motorista updateMotorista(Motorista motorista);

}
