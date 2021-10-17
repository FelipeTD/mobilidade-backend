package com.bot.repository;

import org.springframework.stereotype.Component;

import com.bot.entity.ResponseLogin;
import com.bot.entity.Usuario;

@Component
public class LoginRepository {
	
	public ResponseLogin login(Usuario usuario) {
		
		ResponseLogin response = new ResponseLogin();
		
		if (usuario.getUsuario().equals("Diogo") && usuario.getSenha().equals("123456")) {
			response.setStatus("200");
			response.setToken("Eajl7xps");
		} else if (usuario.getUsuario().equals("Eli") && usuario.getSenha().equals("654321")) {
			response.setStatus("200");
			response.setToken("Eajm30xpm");
		} else {
			response.setStatus("400");
			response.setToken("");
		}
		
		return response;
		
	}

}
