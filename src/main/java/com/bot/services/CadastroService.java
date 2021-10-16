package com.bot.services;

import com.bot.entity.cadastro.Cadastro;
import com.bot.entity.cadastro.CadastroList;

public interface CadastroService {
	
	CadastroList findCadastros();
	
	Cadastro salvar(Cadastro cadastro);

}
