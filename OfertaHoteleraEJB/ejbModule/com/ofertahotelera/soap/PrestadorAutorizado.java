package com.ofertahotelera.soap;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PrestadorAutorizado
 */
@Stateless
@LocalBean
public class PrestadorAutorizado implements PrestadorAutorizadoRemote, PrestadorAutorizadoLocal {

    /**
     * Default constructor. 
     */
    public PrestadorAutorizado() {
    	
    }

}
