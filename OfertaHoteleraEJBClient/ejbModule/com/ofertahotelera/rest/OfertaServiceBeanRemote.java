package com.ofertahotelera.rest;

import javax.ejb.Remote;

@Remote
public interface OfertaServiceBeanRemote {

	void altaOferta(String ofertaJson, String idHab);
}
