package com.ofertahotelera.rest;

import javax.ejb.Local;

@Local
public interface OfertaServiceBeanLocal {
	
	void altaOferta(String ofertaJson, String idHab);
}
