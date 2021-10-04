package com.bot.entity.cadastro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bot.entity.aplicativo.Aplicativo;
import com.bot.entity.motorista.Motorista;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cadastro")
public class Cadastro implements Serializable {
	
	private static final long serialVersionUID = 4217116498497938578L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cadastroId;
	
	@Column(name = "numero_aplicativo")
    private String numeroAplicativo;
	
	@ManyToOne
	@JoinColumn(name="aplicativo_id")
    private Aplicativo aplicativo;
	
	@ManyToOne
	@JoinColumn(name="driver_id")
    private Motorista driver;

}
