package com.ofertahotelera.rest;

import javax.ejb.Remote;

@Remote
public interface EstablecimientoServiceBeanRemote {
	public String sayHello(String name);
	public int altaHotel(String hotel);
	public void agregarHab(String habitacion);
}
