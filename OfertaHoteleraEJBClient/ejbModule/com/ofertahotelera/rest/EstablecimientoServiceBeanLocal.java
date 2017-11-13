package com.ofertahotelera.rest;

import javax.ejb.Local;

@Local
public interface EstablecimientoServiceBeanLocal {
	public String sayHello(String name);
	public int altaHotel(String hotel);
	public String agregarHab(String habitacion, String idHotel);
	public String getHotelesActivos();
	public String getHotel(String idHotel);
	public void grabarIdBO(int idBO, String idHotel);
	public String getHotelById(String idHab);
}
