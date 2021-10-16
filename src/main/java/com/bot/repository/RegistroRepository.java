package com.bot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bot.entity.registro.Registro;

public interface RegistroRepository extends CrudRepository<Registro, Integer> {
	
	@Query("select r from Registro r inner join r.cadastro")
	List<Registro> findAllRegistros();

}
