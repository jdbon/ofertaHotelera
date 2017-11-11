package com.ofertahotelera.rest;

import javax.ejb.Local;

@Local
public interface EstablecimientoServiceBeanLocal {
	public String sayHello(String name);
	public int altaHotel(String hotel);
	public void agregarHab(String habitacion);
}
