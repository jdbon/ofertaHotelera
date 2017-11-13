package com.ofertahotelera.dto;

import java.util.List;

public class ColaDTO {
	private int codigo_prestador;
	private String nombre;
	private String destino;
	private String fecha_desde;
	private String fecha_hasta;
	private String foto_hotel;
	private String descripcion_hotel;
	private List<String> lista_servicios;
	private float precio_habitacion;
	private int cantidad_personas;
	private String foto_habitacion;
	private String descripcion_habitacion;
	private List<String> lista_servicios_habitacion;
	private double latitud;
	private double longitud;
	private String politica_cancelacion;
	private List<Integer> medio_pago_hotel;
	private String email_hotel;
	private int cupo;
	
	
	public ColaDTO(int codigo_prestador, String nombre, String destino, String fdesde, String fhasta, String foto,
			String descripcion, List<String> serviciosHotel, float precioOferta, int cantPersonas, String fotoHab,
			String descripcionHab, List<String> listaServiciosHab, double lat, double longi, String politica,
			List<Integer> mediosDePago, String email, int cupoOferta) {
		super();
		this.codigo_prestador = codigo_prestador;
		this.nombre = nombre;
		this.destino = destino;
		this.fecha_desde = fdesde;
		this.fecha_hasta = fhasta;
		this.foto_hotel = foto;
		this.descripcion_hotel = descripcion;
		this.lista_servicios = serviciosHotel;
		this.precio_habitacion = precioOferta;
		this.cantidad_personas = cantPersonas;
		this.foto_habitacion = fotoHab;
		this.descripcion_habitacion = descripcionHab;
		this.lista_servicios_habitacion = listaServiciosHab;
		this.latitud = lat;
		this.longitud = longi;
		this.politica_cancelacion = politica;
		this.medio_pago_hotel = mediosDePago;
		this.email_hotel = email;
		this.cupo = cupoOferta;
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
	public String getFecha_desde() {
		return fecha_desde;
	}
	public void setFecha_desde(String fdesde) {
		this.fecha_desde = fdesde;
	}
	public String getFecha_hasta() {
		return fecha_hasta;
	}
	public void setFecha_hasta(String fhasta) {
		this.fecha_hasta = fhasta;
	}
	public String getFoto_hotel() {
		return foto_hotel;
	}
	public void setFoto_hotel(String foto) {
		this.foto_hotel = foto;
	}
	public String getDescripcion_hotel() {
		return descripcion_hotel;
	}
	public void setDescripcion_hotel(String descripcion) {
		this.descripcion_hotel = descripcion;
	}
	public List<String> getLista_servicios() {
		return lista_servicios;
	}
	public void setLista_servicios(List<String> serviciosHotel) {
		this.lista_servicios = serviciosHotel;
	}
	public float getPrecio_habitacion() {
		return precio_habitacion;
	}
	public void setPrecio_habitacion(float precioOferta) {
		this.precio_habitacion = precioOferta;
	}
	public int getCantidad_personas() {
		return cantidad_personas;
	}
	public void setCantidad_personas(int cantPersonas) {
		this.cantidad_personas = cantPersonas;
	}
	public String getFoto_habitacion() {
		return foto_habitacion;
	}
	public void setFoto_habitacion(String fotoHab) {
		this.foto_habitacion = fotoHab;
	}
	public String getDescripcion_habitacion() {
		return descripcion_habitacion;
	}
	public void setDescripcion_habitacion(String descripcionHab) {
		this.descripcion_habitacion = descripcionHab;
	}
	public List<String> getLista_servicios_habitacion() {
		return lista_servicios_habitacion;
	}
	public void setLista_servicios_habitacion(List<String> listaServiciosHab) {
		this.lista_servicios_habitacion = listaServiciosHab;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double lat) {
		this.latitud = lat;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longi) {
		this.longitud = longi;
	}
	public String getPolitica_cancelacion() {
		return politica_cancelacion;
	}
	public void setPolitica_cancelacion(String politica) {
		this.politica_cancelacion = politica;
	}
	public List<Integer> getMedio_pago_hotel() {
		return medio_pago_hotel;
	}
	public void setMedio_pago_hotel(List<Integer> mediosDePago) {
		this.medio_pago_hotel = mediosDePago;
	}
	public String getEmail_hotel() {
		return email_hotel;
	}
	public void setEmail_hotel(String email) {
		this.email_hotel = email;
	}
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupoOferta) {
		this.cupo = cupoOferta;
	}
	
	
	
}
