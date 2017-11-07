package com.ofertahotelera.entity;
import java.util.*;

import javax.persistence.*;

@Entity
public class Habitacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idHabitacion")
	private int id;
	private String descripcion;
	private int cantPersonas;
	@ElementCollection(targetClass=String.class)
	@JoinTable(joinColumns=@JoinColumn(name="idHabitacion"))
	@Column (name="url")
	private List<String> fotos;
	private String tipo; // vendria a ser la categoria de la hab
	@OneToMany
	@JoinColumn(name="idServicio")
	private List<Servicio> servicios;
	
	public Habitacion() {
		super();
		this.cantPersonas=0;
		this.descripcion="";
		this.fotos = new ArrayList<String>();
		this.tipo="";
		this.servicios=new ArrayList<Servicio>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantPersonas() {
		return cantPersonas;
	}
	public void setCantPersonas(int cantPersonas) {
		this.cantPersonas = cantPersonas;
	}
	public List<String> getFotos() {
		return fotos;
	}
	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	
	
}
