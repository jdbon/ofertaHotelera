package com.ofertahotelera.rest;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.gson.Gson;
import com.ofertahotelera.entity.*;

/**
 * Session Bean implementation class OfertaBean
 */
@Stateless
@LocalBean
public class OfertaServiceBean implements OfertaServiceBeanRemote, OfertaServiceBeanLocal {

	@PersistenceContext(unitName="MyPU")
	private EntityManager manager;
	
    /**
     * Default constructor. 
     */
    public OfertaServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
	public void altaOferta(String json, String idHab)
	{
		Habitacion hab= new Habitacion();
		hab= this.getHabitacion(idHab);
		System.out.println("recupere hab");
		Gson gson= new Gson();
		Oferta oferta = new Oferta();
		oferta= gson.fromJson(json, Oferta.class);
		System.out.println("json a oferta");
		oferta.setHabitacion(hab);
		
    
    	try {
    		System.out.println("voy a persistir");
    		manager.persist(oferta);
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("error al guardar oferta " + e.getMessage());
    	}
	}
	
	
	@SuppressWarnings("unused")
	private Habitacion getHabitacion(String idHab){
		
    	try {
    		return manager.find(Habitacion.class, Integer.parseInt(idHab));
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("obteniendo hotel por Id (String)" + e.getMessage());
    	}
    	return null;

	}

}
