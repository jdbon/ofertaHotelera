package com.ofertahotelera.dto;

public class ServicioDTO {
	
	//private int id;
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	
	private String nombre;
	private String tipoDeServicio; //servicio de hotel (HO) o de hab (HA)
	
	
	public ServicioDTO() {
		super();
		this.nombre="";
		this.tipoDeServicio="";
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
