package com.bot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bot.entity.login.ResponseLogin;
import com.bot.entity.login.Usuario;
import com.bot.repository.LoginRepository;

@RestController
public class LoginService {
	
	@Autowired
	private LoginRepository repository;
	
	@PostMapping("/login")
	public ResponseLogin login(@RequestBody Usuario usuario) {
		
		ResponseLogin response = repository.login(usuario);
		
		return response;
		
	}

}
