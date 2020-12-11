package com.gustavo.romero.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	private Integer idProducto;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false, foreignKey = @ForeignKey(name = "FK_producto_categoria"))
	private Categoria categoria;
	
	
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;
	
	@Column
	private Float precio;
	
	@Column
	private Integer stock;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
