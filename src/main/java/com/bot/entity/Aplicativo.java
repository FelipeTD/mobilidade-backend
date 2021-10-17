package com.bot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aplicativo")
public class Aplicativo implements Serializable {

	private static final long serialVersionUID = -6161351099517467755L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aplicativoId;

	@Column(name = "nome_aplicativo")
    private String nomeAplicativo;
    
	@Column(name = "active")
    private boolean active;

}
