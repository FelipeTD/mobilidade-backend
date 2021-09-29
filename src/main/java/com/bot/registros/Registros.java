package com.bot.registros;

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
@Table(name = "registros")
public class Registros implements Serializable {
	
	private static final long serialVersionUID = 9062915818803267541L;
	
	@Id
	private Long registroId;
	
	@Column(name = "cadastro_id")
	private String cadastroId;
	
	@Column(name = "valor")
	private Double valor;
	
	@Column(name = "registro_data")
	private Calendar registroData;

}
