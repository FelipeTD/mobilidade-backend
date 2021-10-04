package com.bot.services;

import com.bot.entity.aplicativo.Aplicativo;
import com.bot.entity.aplicativo.AplicativoList;

public interface AplicativoService {
	
	AplicativoList findAllActiveAplicativos();
	
	Aplicativo salvar(Aplicativo aplicativo);
	
	AplicativoList updateAplicativo(Aplicativo aplicativo);

}
