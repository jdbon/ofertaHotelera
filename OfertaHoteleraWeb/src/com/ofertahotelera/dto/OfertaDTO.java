package com.ofertahotelera.dto;

public class OfertaDTO {
	

	private int id;
	
	private String nombreOferta;
	private String nombreHotel;
	private String fechaDesde;
	private String fecHasta;
	private int cupo;

	private HabitacionDTO habitacion;
	private float precio;
	private String politicaCanc;
	private String estado;
	
	// Create an instance of SimpleDateFormat used for formatting 
	// the string representation of date (month/day/year)
	//DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	// Get the date today using Calendar object.
	//Date today = Calendar.getInstance().getTime();        
	// Using DateFormat format method we can create a string 
	// representation of a date with the defined format.
	//String reportDate = df.format(today);

	// Print what date is today!
	//System.out.println("Report Date: " + reportDate);
	
	public OfertaDTO() {
		super();
		this.cupo=0;
		this.estado="";
		this.fechaDesde="";
		this.fecHasta="";
		this.precio=0;
		this.nombreHotel="";
		this.nombreOferta="";
		this.habitacion=new HabitacionDTO();
		this.politicaCanc="";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFechaDesde() {
		return fechaDesde;
	}


	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	public String getFecHasta() {
		return fecHasta;
	}


	public void setFecHasta(String fecHasta) {
		this.fecHasta = fecHasta;
	}


	public int getCupo() {
		return cupo;
	}


	public void setCupo(int cupo) {
		this.cupo = cupo;
	}


	public HabitacionDTO getHabitacion() {
		return habitacion;
	}


	public void setHabitacion(HabitacionDTO habitacion) {
		this.habitacion = habitacion;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public String getPoliticaCanc() {
		return politicaCanc;
	}


	public void setPoliticaCanc(String politicaCanc) {
		this.politicaCanc = politicaCanc;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getNombreOferta() {
		return nombreOferta;
	}


	public void setNombreOferta(String nombreOferta) {
		this.nombreOferta = nombreOferta;
	}


	public String getNombreHotel() {
		return nombreHotel;
	}


	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}
	
	
	

}
