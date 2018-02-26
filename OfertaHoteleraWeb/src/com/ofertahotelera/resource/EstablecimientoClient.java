package com.ofertahotelera.resource;


import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ofertahotelera.integracion.InterfacesBO;
import com.ofertahotelera.rest.EstablecimientoServiceBeanRemote;

public class EstablecimientoClient {

	private static EstablecimientoClient instance = null;
	private static InterfacesBO interfaz = InterfacesBO.getInstancia();
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

	public String agregarHab(String ha, String idHotel) throws Exception {

		return mbr.agregarHab(ha, idHotel);

	}

	public String getHotelesActivos() {

		return mbr.getHotelesActivos();
	}
	
	public String getHotel(String idhotel) {

		return mbr.getHotel(idhotel);
	}

	public void enviarSolicitud(String solicitud, String idHotel) {
			
		
		String rta="";
		try {
			 rta= interfaz.enviarSolicitudBO(solicitud);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error al enviar solitud al BO" + e.getMessage());
		}
		
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(rta).getAsJsonObject();
		int idBO = obj.get("id").getAsInt();
		System.out.println("el id de BO: "+idBO);
		
		mbr.grabarIdBO(idBO,idHotel);
	}

	public String getHotelByHab(String idHab) {
		return mbr.getHotelById(idHab);
	}

	public void grabarLog(String json) {
		
		
		try {
			  interfaz.enviarLog(json);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error al enviar solitud al BO" + e.getMessage());
		}
		
	}

	
}
