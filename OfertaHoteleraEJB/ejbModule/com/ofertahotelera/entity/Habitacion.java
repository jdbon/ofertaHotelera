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
//	@ElementCollection(targetClass=String.class)
//	@JoinTable(joinColumns=@JoinColumn(name="idHabitacion"))
//	@Column (name="url")
	private String foto;
	private String tipo; // vendria a ser la categoria de la hab
	  @OneToMany(cascade=CascadeType.ALL)
	    @JoinTable(
	            name="Habitacion_Servicio",
	            joinColumns = @JoinColumn( name="idHabitacion"),
	            		inverseJoinColumns = @JoinColumn( name="idServicio")
	    )
	private List<Servicio> servicios;
	
	public Habitacion() {
		super();
		this.cantPersonas=0;
		this.descripcion="";
		this.foto ="";
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
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
