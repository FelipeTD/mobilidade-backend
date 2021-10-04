package com.bot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bot.entity.cadastro.Cadastro;

public interface CadastroRepository extends CrudRepository<Cadastro, String> {
	
	@Query("select c from Cadastro c inner join c.aplicativo inner join c.driver")
	List<Cadastro> findCadastros();

}
