package com.ofertahotelera.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.google.gson.Gson;
import com.ofertahotelera.entity.EstadoHotel;
import com.ofertahotelera.entity.Habitacion;
import com.ofertahotelera.entity.Hotel;

/**
 * Session Bean implementation class EstablecimientoBean
 */
@Stateless
@LocalBean
public class EstablecimientoServiceBean implements EstablecimientoServiceBeanRemote, EstablecimientoServiceBeanLocal {

	@PersistenceContext(unitName="MyPU")
	private EntityManager manager;
	
    /**
     * Default constructor. 
     */
    public EstablecimientoServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
	public String sayHello(String name) {	
		return "Hello " + name + ", EJB from a JAX-RS resource.";
	}
    
    public int altaHotel(String h) {
    	Gson gson = new Gson();
    	Hotel hotel = new Hotel();
    	hotel = gson.fromJson(h,Hotel.class);
    	try {
    		manager.persist(hotel);
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("error dando de alta hotel " + e.getMessage());
    	}
		return hotel.getId();
	}
	
	public String agregarHab(String ha, String idHotel) {	
		Hotel hotel= new Hotel();
		hotel=this.gethotel(Integer.parseInt(idHotel));
    	Habitacion hab = new Habitacion();
    	Gson gson = new Gson();
    	hab = gson.fromJson(ha, Habitacion.class);
    	hotel.getHabitaciones().add(hab);
    	try {
    		manager.merge(hotel);
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("error al agregar hab " + e.getMessage());
    	}
    	String habitacionesJson = gson.toJson(hotel.getHabitaciones());
    	return habitacionesJson;
	}
	
	public String getHotelesActivos(){
		
		List<Hotel> hoteles = new ArrayList<>();
    	try {

//    		List hoteles2 =  manager.createQuery(
//				    "SELECT h FROM Hotel h WHERE h.estado = ?1")
//				    .setParameter(1, EstadoHotel.Aprobado)
//				    .getResultList();
    		List hoteles2 =  manager.createQuery(
				    "SELECT h FROM Hotel h")
				    .getResultList();
    		
    		hoteles = (List<Hotel>) hoteles2;
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("Error al ejecutar la consulta de hoteles activos: " + e.getMessage());
    	}
    	Gson gson = new Gson();
    	return gson.toJson(hoteles);
	    
	}
	
	public Hotel gethotel(int idHotel){
		Hotel hotel = null;
    	try {
    		hotel = manager.find(Hotel.class, idHotel);
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("obteniendo hotel por Id (int) " + e.getMessage());
    	}
    	
    	return hotel;
	}
	
	public String getHotel(String idHotel){
		Hotel hotel = null;
    	try {
    		hotel = manager.find(Hotel.class, Integer.parseInt(idHotel));
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("obteniendo hotel por Id (String)" + e.getMessage());
    	}
    	Gson gson = new Gson();
    	
    	return gson.toJson(hotel);
	}

	@Override
	public void grabarIdBO(int idBO, String idHotel) {
		// TODO Auto-generated method stub
		Hotel hotel= new Hotel();
		hotel=this.gethotel(Integer.parseInt(idHotel));
		hotel.setIdBO(idBO);
		
		try {
    		manager.merge(hotel);
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("error al agregar idBO " + e.getMessage());
    	}
		
	}

	@Override
	public String getHotelById(String idHab) {
		Hotel hotel = null;
    	try {
    		hotel = (Hotel) manager.createQuery(
				    "SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.id = ?1")
				    .setParameter(1, Integer.parseInt(idHab))
				    .getSingleResult();
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("obteniendo hotel por IdHab " + e.getMessage());
    	}
    	Gson gson = new Gson();
    	System.out.println("------------hotel es: "+gson.toJson(hotel));
    	return gson.toJson(hotel);
	}


	





}
