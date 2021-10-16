package com.bot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bot.entity.motorista.Motorista;

public interface MotoristaRepository extends CrudRepository<Motorista, String> {
	
	@Query("select m from Motorista m")
	List<Motorista> findDrivers();
	
	@Query("select m from Motorista m where m.active = true")
	List<Motorista> findActiveDrivers();

}
