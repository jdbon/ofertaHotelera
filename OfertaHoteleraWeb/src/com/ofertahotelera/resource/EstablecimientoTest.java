package com.ofertahotelera.resource;



import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.ofertahotelera.rest.EstablecimientoServiceBeanRemote;

public class EstablecimientoTest {

	
	public void hacer(String h) throws Exception{
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
					EstablecimientoServiceBeanRemote mbr = (EstablecimientoServiceBeanRemote)context.lookup(lookupName);
					
//					Hotel hotel = new Hotel();
//					hotel.setDescripcion(h.getDescripcion());
//					hotel.setDestino(h.getDestino());
//					hotel.setDireccion(h.getDireccion());
//					hotel.setEmail(h.getEmail());
//					hotel.setEstado(EstadoHotel.Pendiente);
//					hotel.setLatitud(h.getLatitud());
//					hotel.setLongitud(h.getLongitud());
					
					System.out.println("llega");
					System.out.println("Respuesta: " + mbr.altaHotel(h));
	}
	
}
