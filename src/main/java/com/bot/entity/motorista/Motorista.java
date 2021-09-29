package com.bot.entity.motorista;

import java.io.Serializable;

import javax.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "motorista")
public class Motorista implements Serializable {

	private static final long serialVersionUID = -7623173312450062542L;

	@Id
    private String driverId;

	@Column(name = "driver_name")
    private String driverName;
    
	@Column(name = "active")
    private boolean active;
	
}