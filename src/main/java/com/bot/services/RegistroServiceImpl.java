package com.bot.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bot.entity.Cadastro;
import com.bot.entity.Registro;
import com.bot.entity.RegistroList;
import com.bot.entity.RegistroRequest;
import com.bot.entity.Resultado;
import com.bot.entity.Valor;
import com.bot.repository.CadastroRepository;
import com.bot.repository.RegistroRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegistroServiceImpl implements RegistroService {
	
	private final RegistroRepository repository;
	private final CadastroRepository cadastroRepository;
	
	@Override
	public RegistroList findAllRegistros() {
		
		RegistroList response = new RegistroList();
		response.setRegistros(repository.findAllRegistros());
		
		Collections.sort(response.getRegistros(), Comparator.comparing(Registro::getRegistroId));	
		
		return response;
		
	}
	
	@Override
	public Resultado findResults(String data) {
		
		List<Registro> registros = repository.findRegistrosByDate(data);
		
		Double totalUber = Double.valueOf(0);
		Double totalFreenow = Double.valueOf(0);
		Double totalBolt = Double.valueOf(0);
		
		Double totalAluguer = Double.valueOf(0);
		Double totalViaverde = Double.valueOf(0);
		Double totalBP = Double.valueOf(0);
		Double totalPrio = Double.valueOf(0);
		
		for (Registro registro : registros) {
			
			switch (registro.getCadastro().getAplicativo().getAplicativoId()) {
				case 1:
					totalUber = totalUber + registro.getValor();
					break;
				case 2:
					totalFreenow = totalFreenow + registro.getValor();
					break;
				case 3:
					totalBolt = totalBolt + registro.getValor();
					break;
				case 4:
					totalAluguer = totalAluguer + registro.getValor();
					break;
				case 5:
					totalViaverde = totalViaverde + registro.getValor();
					break;
				case 6:
					totalBP = totalBP + registro.getValor();
					break;
				case 7:
					totalPrio = totalPrio + registro.getValor();
					break;
				default:
					break;
			}
			
		}
		
		Double totalGanhos = totalUber + totalFreenow + totalBolt;
		Double totalDespesas = totalAluguer + totalViaverde + totalBP + totalPrio;
		Double saldoTotal = totalGanhos - totalDespesas;
		
		List<Valor> ganhos = new ArrayList<>();
		ganhos.add(new Valor("Uber", totalUber, "left"));
		ganhos.add(new Valor("Freenow", totalFreenow, "center"));
		ganhos.add(new Valor("Bolt", totalBolt, "center"));
		ganhos.add(new Valor("Ganhos Totais", totalGanhos, "right"));
		
		List<Valor> despesas = new ArrayList<>();
		despesas.add(new Valor("Aluguer", totalAluguer, "left"));
		despesas.add(new Valor("ViaVerde", totalViaverde, "center"));
		despesas.add(new Valor("BP", totalBP, "center"));
		despesas.add(new Valor("Prio", totalPrio, "right"));
		despesas.add(new Valor("Despesas", totalDespesas, "left"));
		
		List<Valor> saldo = new ArrayList<>();
		saldo.add(new Valor("Total", saldoTotal, "left"));
		saldo.add(new Valor("Dívida", Double.valueOf(0), "left"));
		
		Resultado response = new Resultado(ganhos, despesas, saldo);
		
		return response;
	}
	
	@Override 
	public Registro salvar(RegistroRequest registro) {
		
		Optional<Cadastro> cadastro = cadastroRepository.findById(Integer.parseInt(registro.getCadastroId().toString()));
		
		Registro newRegistro = new Registro();
		newRegistro.setCadastro(cadastro.get());
		newRegistro.setValor(registro.getValor());
		
		String[] data = registro.getRegistroData().split(",");
		String dia = data[0].substring(0, 2);
		String mes = data[0].substring(3, 5);
		String ano = data[0].substring(6, 10);
		
		Calendar calendar = new GregorianCalendar(Integer.parseInt(ano), Integer.parseInt(mes) - 1, Integer.parseInt(dia));
		newRegistro.setRegistroData(calendar);
		
		System.out.println(newRegistro.getRegistroData());
		
		try {
			Registro response = repository.save(newRegistro);
			return response;
		} catch (IllegalArgumentException error) {
			return null;
		}
		
	}

}
