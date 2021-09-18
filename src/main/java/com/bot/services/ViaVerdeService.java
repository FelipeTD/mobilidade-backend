package com.bot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bot.entity.viaverde.CardPayments;
import com.bot.repository.ViaVerdeRepository;

@RestController
public class ViaVerdeService {
	
	@Autowired
	private ViaVerdeRepository repository;
	
	@GetMapping("/viaverde/ganhos")
	public CardPayments getViaVerdeData() {
		
		// TODO Falta passar as datas para o repository
		
		CardPayments response = repository.getViaVerdeData();
		
		return response;
		
	}

}
