package com.bot.services;

import com.bot.entity.motorista.Motorista;
import com.bot.entity.motorista.MotoristaList;

public interface MotoristaService {
	
	MotoristaList findAllDrivers();
	
	Motorista salvar(Motorista motorista);
	
	MotoristaList updateMotorista(Motorista motorista);

}
