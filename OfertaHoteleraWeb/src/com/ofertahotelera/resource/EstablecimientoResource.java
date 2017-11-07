package com.ofertahotelera.resource;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.ofertahotelera.rest.EstablecimientoServiceBean;

@Path("/hello")
@Stateless
public class EstablecimientoResource {

	Logger logger = Logger.getLogger(EstablecimientoResource.class.getName());
	
	@EJB
	EstablecimientoServiceBean service;
	
	@GET
	public String hello(@QueryParam("name") String name) {
		String hellGreeting = service.sayHello(name);
		logger.info(hellGreeting);
		return hellGreeting;
	}
	
}