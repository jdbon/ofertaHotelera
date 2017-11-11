package com.ofertahotelera.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;


@Entity
public class Hotel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idHotel")
	private int id;
	@Column(name="nombreHotel")
	private String nombre;
	private String direccion;
	@Enumerated(EnumType.STRING)
	private EstadoHotel estado; //Opciones: P [pendiente], A [aprobado], R [rechazado]
	private int latitud;
	private int longitud;
	private String descripcion;
	  @OneToMany(cascade=CascadeType.ALL)
	    @JoinTable(
	            name="Hotel_Servicio",
	            joinColumns = @JoinColumn( name="idHotel"),
	            		inverseJoinColumns = @JoinColumn( name="idServicio")
	    )
	private List<Servicio> servicios;
	  
	@ElementCollection(targetClass=MedioDePago.class)
	@JoinTable(joinColumns=@JoinColumn(name="idHotel"))
	@Enumerated(EnumType.STRING)
	@Column (name="medioDePago")
	private List<MedioDePago> medioDePagos;
	
	@ElementCollection(targetClass=String.class)
	@JoinTable(joinColumns=@JoinColumn(name="idHotel"))
	@Column (name="url")
	private List<String> fotos;
	
	private String email;
	private String destino; //falta definirlo por el profesor
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="idHotel")
	private List<Habitacion> habitaciones;
	
	private int idBO;
	
	public Hotel() {
		super();
		this.descripcion="";
		this.destino="";
		this.direccion="";
		this.email="";
		this.estado=EstadoHotel.Pendiente;
		this.latitud=0;
		this.longitud=0;
		this.nombre="";
		this.servicios=new ArrayList<Servicio>();
		this.medioDePagos=new ArrayList<MedioDePago>();
		this.fotos=new ArrayList<String>();
		this.habitaciones=new ArrayList<Habitacion>();
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
	public int getLatitud() {
		return latitud;
	}
	public void setLatitud(int latitud) {
		this.latitud = latitud;
	}
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
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
	
	public EstadoHotel getEstado() {
		return estado;
	}
	public void setEstado(EstadoHotel estado) {
		this.estado = estado;
	}
	public List<MedioDePago> getMedioDePagos() {
		return medioDePagos;
	}
	public void setMedioDePagos(List<MedioDePago> medioDePagos) {
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
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	public int getIdBO() {
		return idBO;
	}
	public void setIdBO(int idBO) {
		this.idBO = idBO;
	}
	
	
	
	
}