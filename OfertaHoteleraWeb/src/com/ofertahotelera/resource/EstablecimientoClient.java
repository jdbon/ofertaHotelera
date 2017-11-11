package com.ofertahotelera.resource;



import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.ofertahotelera.rest.EstablecimientoServiceBeanRemote;

public class EstablecimientoClient {

	private static EstablecimientoClient instance = null;
	private EstablecimientoServiceBeanRemote mbr;
		
	protected EstablecimientoClient() {
		super();
		this.getConnection();
	}
	
	public static EstablecimientoClient getInstancia() {
		if (instance == null) {
			instance = new EstablecimientoClient();
		}
		return instance;
	}

	public void getConnection() {
		try {
			// Stateless
			@SuppressWarnings("rawtypes")
			final Hashtable<String, Comparable> jndiProperties = new Hashtable<String, Comparable>();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming"); 
			jndiProperties.put("jboss.naming.client.ejb.context", true);
			final Context context = new InitialContext(jndiProperties);
			final String earName = "OfertaHoteleraEAR"; // Nombre del módulo EAR
			final String ejbModuleName = "OfertaHoteleraEJB"; // Nombre del módulo EJB
			final String distinctName = ""; // Opcional para resolver repeticiones en nombres 
			final String ejbClassName = "EstablecimientoServiceBean"; // Nombre corto del EJB
			final String fullInterfaceName = EstablecimientoServiceBeanRemote.class.getName();
			String lookupName = "ejb:" + earName + "/" + ejbModuleName + "/" + distinctName + "/" + ejbClassName + "!" + fullInterfaceName;
			System.out.println("Conectando a " + lookupName);
			mbr = (EstablecimientoServiceBeanRemote)context.lookup(lookupName);
		} catch (Exception e) {
			e.printStackTrace();
		}					
	}
	
	public int altaHotel(String h) throws Exception {

		int idHotel = mbr.altaHotel(h);					
		return idHotel;
	}

	public void agregarHab(String ha) throws Exception {

		mbr.agregarHab(ha);

	}

	
}
