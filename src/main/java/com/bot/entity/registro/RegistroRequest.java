package com.bot.entity.registro;

public class RegistroRequest {
	
	private Long cadastroId;
	private Double valor;
	private String registroData;
	
	public Long getCadastroId() {
		return cadastroId;
	}
	public void setCadastroId(Long cadastroId) {
		this.cadastroId = cadastroId;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getRegistroData() {
		return registroData;
	}
	public void setRegistroData(String registroData) {
		this.registroData = registroData;
	}

}
