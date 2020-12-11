package com.gustavo.romero.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "boleta")
public class Boleta {
	
	@Id
	private Integer idBoleta;
	
	@ManyToOne
	@JoinColumn(name = "id_orden", nullable = false, foreignKey = @ForeignKey(name = "FK_boleta_orden"))
	private Orden orden;
	
	@ManyToOne
	@JoinColumn(name = "id_recinto", nullable = false, foreignKey = @ForeignKey(name = "FK_boleta_recinto"))
	private Recinto recinto;
	
	@ManyToOne
	@JoinColumn(name = "id_modoPago", nullable = false, foreignKey = @ForeignKey(name = "FK_boleta_ModoPago"))
	private Modo_pago modoPago;
	
	@ManyToOne
	@JoinColumn(name = "id_fechaPago", nullable = false, foreignKey = @ForeignKey(name = "FK_boleta_FechaPago"))
	private Fecha_pago fechaPago;

	public Integer getIdBoleta() {
		return idBoleta;
	}

	public void setIdBoleta(Integer idBoleta) {
		this.idBoleta = idBoleta;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Recinto getRecinto() {
		return recinto;
	}

	public void setRecinto(Recinto recinto) {
		this.recinto = recinto;
	}

	public Modo_pago getModoPago() {
		return modoPago;
	}

	public void setModoPago(Modo_pago modoPago) {
		this.modoPago = modoPago;
	}

	public Fecha_pago getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Fecha_pago fechaPago) {
		this.fechaPago = fechaPago;
	}

	
}
