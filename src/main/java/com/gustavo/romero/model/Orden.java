package com.gustavo.romero.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orden")
public class Orden {

	@Id
	private Integer idOrden;
	
	@Column(name = "cantidad", nullable = false)
	private Integer  cantidad;
	
	@Column(name = "estado", nullable = false)
	private boolean enabled;
	
	private LocalDateTime fecha_orden;
	
	@ManyToOne
	@JoinColumn(name = "idProducto", nullable = false, foreignKey = @ForeignKey(name = "FK_orden_producto_"))
	private Producto producto;

	public Integer getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getFecha_orden() {
		return fecha_orden;
	}

	public void setFecha_orden(LocalDateTime fecha_orden) {
		this.fecha_orden = fecha_orden;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	

	
	
}
