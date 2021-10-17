package com.bot.services;

import com.bot.entity.Registro;
import com.bot.entity.RegistroList;
import com.bot.entity.RegistroRequest;
import com.bot.entity.Resultado;

public interface RegistroService {
	
	RegistroList findAllRegistros();
	
	Registro salvar(RegistroRequest registro);
	
	Resultado findResults(String data);

}
