package com.ofertahotelera.dto;

import java.util.*;

public class HotelDTO {

	private int id;

	private String nombre;
	private String direccion;

	private EstadoHotelDTO estado; //Opciones: P [pendiente], A [aprobado], R [rechazado]
	private Double latitud;
	private Double longitud;
	private String descripcion;
	private List<ServicioDTO> servicios;
	private List<MedioDePagoDTO> medioDePagos;
	private String foto;
	private String email;
	private String destino; //falta definirlo por el profesor
	private List<HabitacionDTO> habitaciones;
	private int idBO;
	
	public HotelDTO() {
		super();
		this.descripcion="";
		this.destino="";
		this.direccion="";
		this.email="";
		this.estado=EstadoHotelDTO.Pendiente;
		this.latitud= 0.1d;
		this.longitud= 0.1d;
		this.nombre="";
		this.servicios=new ArrayList<ServicioDTO>();
		this.medioDePagos=new ArrayList<MedioDePagoDTO>();
		this.foto="";
		this.habitaciones=new ArrayList<HabitacionDTO>();
		this.idBO = 0;
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
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double i) {
		this.latitud = i;
	}
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double i) {
		this.longitud = i;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<ServicioDTO> getServicios() {
		return servicios;
	}
	public void setServicios(List<ServicioDTO> servicios) {
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
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
	public int getIdBO() {
		return idBO;
	}
	public void setIdBO(int idBO) {
		this.idBO = idBO;
	}
	
	
}