package com.ofertahotelera.entity;

import javax.persistence.*;

@Entity
public class Servicio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="idServicio")
	private int id;
	
	@Column(name="nombreServicio")
	private String nombre;
	private String tipoDeServicio; //servicio de hotel (HO) o de hab (HA)
	
	
	public Servicio() {
		super();
		this.nombre="";
		this.tipoDeServicio="";
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
	public String getTipoDeServicio() {
		return tipoDeServicio;
	}
	public void setTipoDeServicio(String tipoDeServicio) {
		this.tipoDeServicio = tipoDeServicio;
	}
	
	

	
	
}
