package com.bot.services;

import com.bot.entity.Motorista;
import com.bot.entity.MotoristaList;

public interface MotoristaService {
	
	MotoristaList findAllDrivers();
	
	MotoristaList findAllActiveDrivers();
	
	Motorista salvar(Motorista motorista);
	
	MotoristaList updateMotorista(Motorista motorista);

}
