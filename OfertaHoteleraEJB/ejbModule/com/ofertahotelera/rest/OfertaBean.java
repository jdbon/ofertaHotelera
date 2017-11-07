package com.ofertahotelera.rest;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ofertahotelera.entity.Oferta;

/**
 * Session Bean implementation class OfertaBean
 */
@Stateless
@LocalBean
public class OfertaBean implements OfertaBeanRemote, OfertaBeanLocal {

	@PersistenceContext(unitName="MyPU")
	private EntityManager manager;
	
    /**
     * Default constructor. 
     */
    public OfertaBean() {
        // TODO Auto-generated constructor stub
    }
    
	public void altaOferta(Oferta oferta)
	{
    	Oferta ofer = new Oferta();
    	try {
    		manager.persist(ofer);
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("Conectado a " + e.getMessage());
    	}
	}

}
