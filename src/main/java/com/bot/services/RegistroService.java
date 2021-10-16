package com.bot.services;

import com.bot.entity.registro.Registro;
import com.bot.entity.registro.RegistroList;
import com.bot.entity.registro.RegistroRequest;

public interface RegistroService {
	
	RegistroList findAllRegistros();
	
	Registro salvar(RegistroRequest registro);

}
