package com.ofertahotelera.dto;

import java.util.ArrayList;
import java.util.List;

public class ColaDTO {
	private int codigo_prestador;
	private String nombre;
	private String destino;
	private String fdesde;
	private String fhasta;
	private String foto;
	private String descripcion;
	private List<String> serviciosHotel;
	private float precioOferta;
	private int cantPersonas;
	private String fotoHab;
	private String descripcionHab;
	private List<String> listaServiciosHab;
	private double lat;
	private double longi;
	private String politica;
	private List<Integer> mediosDePago;
	private String email;
	private int cupoOferta;
	
	
	public ColaDTO(int codigo_prestador, String nombre, String destino, String fdesde, String fhasta, String foto,
			String descripcion, List<String> serviciosHotel, float precioOferta, int cantPersonas, String fotoHab,
			String descripcionHab, List<String> listaServiciosHab, double lat, double longi, String politica,
			List<Integer> mediosDePago, String email, int cupoOferta) {
		super();
		this.codigo_prestador = codigo_prestador;
		this.nombre = nombre;
		this.destino = destino;
		this.fdesde = fdesde;
		this.fhasta = fhasta;
		this.foto = foto;
		this.descripcion = descripcion;
		this.serviciosHotel = serviciosHotel;
		this.precioOferta = precioOferta;
		this.cantPersonas = cantPersonas;
		this.fotoHab = fotoHab;
		this.descripcionHab = descripcionHab;
		this.listaServiciosHab = listaServiciosHab;
		this.lat = lat;
		this.longi = longi;
		this.politica = politica;
		this.mediosDePago = mediosDePago;
		this.email = email;
		this.cupoOferta = cupoOferta;
	}
	public int getCodigo_prestador() {
		return codigo_prestador;
	}
	public void setCodigo_prestador(int codigo_prestador) {
		this.codigo_prestador = codigo_prestador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getFdesde() {
		return fdesde;
	}
	public void setFdesde(String fdesde) {
		this.fdesde = fdesde;
	}
	public String getFhasta() {
		return fhasta;
	}
	public void setFhasta(String fhasta) {
		this.fhasta = fhasta;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<String> getServiciosHotel() {
		return serviciosHotel;
	}
	public void setServiciosHotel(List<String> serviciosHotel) {
		this.serviciosHotel = serviciosHotel;
	}
	public float getPrecioOferta() {
		return precioOferta;
	}
	public void setPrecioOferta(float precioOferta) {
		this.precioOferta = precioOferta;
	}
	public int getCantPersonas() {
		return cantPersonas;
	}
	public void setCantPersonas(int cantPersonas) {
		this.cantPersonas = cantPersonas;
	}
	public String getFotoHab() {
		return fotoHab;
	}
	public void setFotoHab(String fotoHab) {
		this.fotoHab = fotoHab;
	}
	public String getDescripcionHab() {
		return descripcionHab;
	}
	public void setDescripcionHab(String descripcionHab) {
		this.descripcionHab = descripcionHab;
	}
	public List<String> getListaServiciosHab() {
		return listaServiciosHab;
	}
	public void setListaServiciosHab(List<String> listaServiciosHab) {
		this.listaServiciosHab = listaServiciosHab;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLongi() {
		return longi;
	}
	public void setLongi(double longi) {
		this.longi = longi;
	}
	public String getPolitica() {
		return politica;
	}
	public void setPolitica(String politica) {
		this.politica = politica;
	}
	public List<Integer> getMediosDePago() {
		return mediosDePago;
	}
	public void setMediosDePago(List<Integer> mediosDePago) {
		this.mediosDePago = mediosDePago;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCupoOferta() {
		return cupoOferta;
	}
	public void setCupoOferta(int cupoOferta) {
		this.cupoOferta = cupoOferta;
	}
	
	
	
}
