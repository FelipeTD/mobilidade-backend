package com.bot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bot.registros.Registros;

public interface RegistroRepository extends CrudRepository<Registros, Long> {
	
	@Query("select r from Registros r where r.cadastroId = :cadastroId "
			+ "and registro_data >= cast(:startDate as date) "
			+ "and registro_data <= cast(:finalDate as date)")
	List<Registros> findRegistrosByIdAndDate(
			@Param("cadastroId") String cadastroId, 
			@Param("startDate") String startDate, 
			@Param("finalDate") String finalDate);

}
