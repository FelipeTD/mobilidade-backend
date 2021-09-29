package com.bot.services;

import java.util.List;

import com.bot.registros.Registros;

public interface RegistroService {
	
	List<Registros> findRegistrosByIdAndDate(String cadastroId, String startDate, String finalDate);
	
	Double findTotalByRegistro(String cadastroId, String startDate, String finalDate);

}
