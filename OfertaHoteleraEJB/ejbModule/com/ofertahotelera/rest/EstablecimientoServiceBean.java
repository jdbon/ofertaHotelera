package com.ofertahotelera.rest;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.gson.Gson;
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
    		System.out.println("Conectado a " + e.getMessage());
    	}
		return hotel.getId();
	}
	
	public void agregarHab(String ha) {		
    	Habitacion hab = new Habitacion();
    	Gson gson = new Gson();
    	hab = gson.fromJson(ha, Habitacion.class);
    	try {
    		manager.persist(hab);
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("Conectado a " + e.getMessage());
    	}
	}
	
//	public List<Hotel> getHoteles(){
//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session s = sf.openSession();
//		List<Hotel> hoteles ;
//		hoteles = s.createQuery("FROM Hotel where estado = 'A'").list();
////		s.close();
//	    return hoteles;
//	    
//	}
//	
	public Hotel gethotel(String idHotel){
		Hotel hotel = null;
    	try {
    		hotel = manager.find(Hotel.class, idHotel);
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("Conectado a " + e.getMessage());
    	}
    	
    	return hotel;
	}
//	
//	public Habitacion getHabitacion(String idHab){
//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session s = sf.openSession();
//		Habitacion h = new Habitacion();
//		h.setId(Integer.parseInt(idHab));
//		s.load(h,h.getId());
//		s.close();
//		return h;
//
//	}



}
