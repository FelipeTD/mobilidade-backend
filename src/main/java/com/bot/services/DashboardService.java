package com.bot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bot.entity.dashboard.DashboardList;
import com.bot.repository.DashboardRepository;

@RestController
public class DashboardService {
	
	@Autowired
	DashboardRepository repository;
	
	@GetMapping("/dashboard")
	public DashboardList getDashboard() {
		
		DashboardList response = repository.getDashboard();
		
		return response;
		
	}

}
