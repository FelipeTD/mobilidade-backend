package com.bot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bot.entity.Registro;

public interface RegistroRepository extends CrudRepository<Registro, Integer> {
	
	@Query("select r from Registro r inner join r.cadastro")
	List<Registro> findAllRegistros();
	
	@Query("select r from Registro r inner join r.cadastro "
			+ "where r.registroData = cast(:registroData as date)")
	List<Registro> findRegistrosByDate(@Param("registroData") String registroData);

}
