package com.ofertahotelera.resource;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.ofertahotelera.rest.OfertaServiceBeanRemote;

public class OfertaClient {
	
	private static OfertaClient instance = null;
	private OfertaServiceBeanRemote mbr;
		
	protected OfertaClient() {
		super();
		this.getConnection();
	}
	
	public static OfertaClient getInstancia() {
		if (instance == null) {
			instance = new OfertaClient();
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
			final String ejbClassName = "OfertaServiceBean"; // Nombre corto del EJB
			final String fullInterfaceName = OfertaServiceBeanRemote.class.getName();
			String lookupName = "ejb:" + earName + "/" + ejbModuleName + "/" + distinctName + "/" + ejbClassName + "!" + fullInterfaceName;
			System.out.println("Conectando a " + lookupName);
			mbr = (OfertaServiceBeanRemote)context.lookup(lookupName);
		} catch (Exception e) {
			e.printStackTrace();
		}					
	}

	public void altaOferta(String ofertaJson, String idHab) {
		System.out.println(idHab + ofertaJson);
		mbr.altaOferta(ofertaJson,idHab);
	}

}
