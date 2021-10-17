package com.bot.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Resultado {
	
	private List<Valor> ganhos;
	private List<Valor> despesas;
	private List<Valor> saldo;

}
