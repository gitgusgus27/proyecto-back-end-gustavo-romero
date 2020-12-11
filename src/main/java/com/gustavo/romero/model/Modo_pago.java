package com.gustavo.romero.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "modo_pago")
public class Modo_pago {
	
	@Id
	private Integer idModoPago;
	
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;
	
	@Column(name = "descripcion", nullable = true, length = 150)
	private String descripcion;

	public Integer getIdModoPago() {
		return idModoPago;
	}

	public void setIdModoPago(Integer idModoPago) {
		this.idModoPago = idModoPago;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

}
