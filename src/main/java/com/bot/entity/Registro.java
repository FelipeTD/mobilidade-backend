package com.bot.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registro")
public class Registro implements Serializable {
	
	private static final long serialVersionUID = 9062915818803267541L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registroId;
	
	@ManyToOne
	@JoinColumn(name="cadastro_id")
	private Cadastro cadastro;
	
	@Column(name = "valor")
	private Double valor;
	
	@Column(name = "registro_data")
	private Calendar registroData;

}
