package com.gustavo.romero.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fecha_pago")
public class Fecha_pago {
	
	@Id
	private Integer idFechaPago;
	
	private LocalDateTime fecha;

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Integer getIdFechaPago() {
		return idFechaPago;
	}

	public void setIdFechaPago(Integer idFechaPago) {
		this.idFechaPago = idFechaPago;
	}
	
	
	
	
	

}
