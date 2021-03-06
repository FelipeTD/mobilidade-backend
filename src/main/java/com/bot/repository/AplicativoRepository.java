package com.bot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bot.entity.Aplicativo;

public interface AplicativoRepository extends CrudRepository<Aplicativo, String> {
	
	@Query("select a from Aplicativo a")
	List<Aplicativo> findAplicativos();
	
	@Query("select a from Aplicativo a where a.active = true")
	List<Aplicativo> findAllActiveAplicativos();

}
