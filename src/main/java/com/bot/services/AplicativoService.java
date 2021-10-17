package com.bot.services;

import com.bot.entity.Aplicativo;
import com.bot.entity.AplicativoList;

public interface AplicativoService {
	
	AplicativoList findAllAplicativos();
	
	AplicativoList findAllActiveAplicativos();
	
	Aplicativo salvar(Aplicativo aplicativo);
	
	AplicativoList updateAplicativo(Aplicativo aplicativo);

}
