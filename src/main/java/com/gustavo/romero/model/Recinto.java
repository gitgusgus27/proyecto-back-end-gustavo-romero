package com.gustavo.romero.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "recinto")
public class Recinto {
	
	@Id
	private Integer idRecinto;
	
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;
	

	@ApiModelProperty(notes = "Dirección debe tener minimo 3 caracteres")
	@Size(min = 3, max = 150, message = "Dirección debe tener minimo 3 caracteres")
	@Column(name = "direccion", nullable = true, length = 150)
	private String direccion;
	
	@ApiModelProperty(notes = "Telefono debe tener 9 caracteres")
	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "telefono", nullable = true, length = 9)
	private String telefono;
	
	@ApiModelProperty(notes = "Celular debe tener 9 caracteres")
	@Size(min = 9, max = 11, message = "celular debe tener mini,o 9 caracteres")
	@Column(name = "Celular", nullable = true, length = 9)
	private String celular;
	
	
	@Email
	@Column(name = "email", nullable = true, length = 55)
	private String email;
	
	@Column(name = "sitio_web", nullable = true)
	private String sitio_web;
	
	@Column(name = "descripcion", nullable = true, length = 150)
	private String descripcion;

	public Integer getIdRecinto() {
		return idRecinto;
	}

	public void setIdRecinto(Integer idRecinto) {
		this.idRecinto = idRecinto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSitio_web() {
		return sitio_web;
	}

	public void setSitio_web(String sitio_web) {
		this.sitio_web = sitio_web;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
