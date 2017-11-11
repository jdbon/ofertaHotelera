package com.ofertahotelera.dto;
import java.util.*;

import javax.persistence.*;


@Entity
public class HabitacionDTO {
	

	private int id;
	private String descripcion;
	private int cantPersonas;
	private List<String> fotos;
	private String tipo; // vendria a ser la categoria de la hab
	private List<ServicioDTO> servicios;
	
	public HabitacionDTO() {
		super();
		this.cantPersonas=0;
		this.descripcion="";
		this.fotos = new ArrayList<String>();
		this.tipo="";
		this.servicios=new ArrayList<ServicioDTO>();
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
	public List<ServicioDTO> getServicios() {
		return servicios;
	}
	public void setServicios(List<ServicioDTO> servicios) {
		this.servicios = servicios;
	}
	
	
	
}
