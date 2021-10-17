package com.bot.services;

import com.bot.entity.Cadastro;
import com.bot.entity.CadastroList;

public interface CadastroService {
	
	CadastroList findCadastros();
	
	Cadastro salvar(Cadastro cadastro);

}
