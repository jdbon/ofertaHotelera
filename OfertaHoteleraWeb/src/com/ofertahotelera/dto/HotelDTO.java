package com.ofertahotelera.dto;

import java.util.*;

public class HotelDTO {

	private int id;

	private String nombre;
	private String direccion;

	private EstadoHotelDTO estado; //Opciones: P [pendiente], A [aprobado], R [rechazado]
	private int latitud;
	private int longitud;
	private String descripcion;
	private List<Servicio> servicios;
	private List<MedioDePagoDTO> medioDePagos;
	private List<String> fotos;
	private String email;
	private String destino; //falta definirlo por el profesor
	private List<HabitacionDTO> habitaciones;
	
	public HotelDTO() {
		super();
		this.descripcion="";
		this.destino="";
		this.direccion="";
		this.email="";
		this.estado=EstadoHotelDTO.Pendiente;
		this.latitud=0;
		this.longitud=0;
		this.nombre="";
		this.servicios=new ArrayList<Servicio>();
		this.medioDePagos=new ArrayList<MedioDePagoDTO>();
		this.fotos=new ArrayList<String>();
		this.habitaciones=new ArrayList<HabitacionDTO>();
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getLatitud() {
		return latitud;
	}
	public void setLatitud(int i) {
		this.latitud = i;
	}
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int i) {
		this.longitud = i;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public EstadoHotelDTO getEstado() {
		return estado;
	}
	public void setEstado(EstadoHotelDTO estado) {
		this.estado = estado;
	}
	public List<MedioDePagoDTO> getMedioDePagos() {
		return medioDePagos;
	}
	public void setMedioDePagos(List<MedioDePagoDTO> medioDePagos) {
		this.medioDePagos = medioDePagos;
	}
	public List<String> getFotos() {
		return fotos;
	}
	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public List<HabitacionDTO> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(List<HabitacionDTO> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	
}