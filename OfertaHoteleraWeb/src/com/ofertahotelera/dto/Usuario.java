package com.ofertahotelera.dto;

import javax.persistence.*;

//@Entity 

public class Usuario {
	
//	@Id 
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column (name="idUsuario")
	private int id;
	private String nombre;
	private String password;
	public Usuario() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
