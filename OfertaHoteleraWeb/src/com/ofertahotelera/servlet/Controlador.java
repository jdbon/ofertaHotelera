package com.ofertahotelera.servlet;

import java.io.IOException;
import java.util.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.ofertahotelera.dto.*;
import com.ofertahotelera.dto.Servicio;
import com.ofertahotelera.entity.*;
import com.ofertahotelera.resource.EstablecimientoTest;


/**
 * Servlet implementation class servlet
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String value =request.getParameter("name");
			if ("AltaHotel".equals(value)){
				System.out.println("entro al Alta Hotel");
				
				String descripcion=request.getParameter("descripcion");
//				String destino=request.getParameter("destino");
				String direccion=request.getParameter("direccion");
				String email=request.getParameter("email");
				//String estado=request.getParameter("estado");
				String fotos=request.getParameter("fotos");
				String latitud=request.getParameter("latitud");
				String longitud=request.getParameter("longitud");
				String medioDePagos=request.getParameter("medioDePagos");
				String nombre=request.getParameter("nombre");
				String servicios=request.getParameter("servicios");
				
				String tarjeta=request.getParameter("Tarjeta");
				String cheque=request.getParameter("Cheque");
				String Mercado_Pago=request.getParameter("Mercado_Pago");
				String PayPal=request.getParameter("PayPal");
				String Pago_en_Destino=request.getParameter("Pago_en_Destino");
				
				
				
				System.out.println(tarjeta);
				System.out.println(cheque);
				System.out.println(Mercado_Pago);
				System.out.println(PayPal);
				System.out.println(Pago_en_Destino);
				
				HotelDTO hotel1 = new HotelDTO();
				hotel1.setDescripcion(descripcion);
//				hotel1.setDestino(destino);
				hotel1.setDestino("bue");
				hotel1.setDireccion(direccion);
				hotel1.setEmail(email);
				//hotel1.setEstado(EstadoHotelDTO.P);
				hotel1.getFotos().add("foo foto foto");
				hotel1.getFotos().add("sahfjafkljdljd");
				hotel1.setLatitud(Integer.parseInt(latitud));
				hotel1.setLongitud(Integer.parseInt(longitud));
//				hotel1.setMedioDePagos(MedioDePago.Tarjeta);
				//hotel1.setId(999);
				//hotel1.getMedioDePagos().add(MedioDePago.Tarjeta);
//				hotel1.getMedioDePagos().add(MedioDePago.valueOf(medioDePagos));
//				System.out.println(MedioDePago.valueOf(medioDePagos));
				hotel1.setNombre(nombre);
				
				if(tarjeta != null){
					hotel1.getMedioDePagos().add(MedioDePagoDTO.valueOf(tarjeta));
				}
					if(cheque != null){
					hotel1.getMedioDePagos().add(MedioDePagoDTO.valueOf(cheque));
				}
					if(Mercado_Pago != null){
					hotel1.getMedioDePagos().add(MedioDePagoDTO.valueOf(Mercado_Pago));
				}
					if(PayPal != null){
					hotel1.getMedioDePagos().add(MedioDePagoDTO.valueOf(PayPal));
				}
					if(Pago_en_Destino != null){
					hotel1.getMedioDePagos().add(MedioDePagoDTO.valueOf(Pago_en_Destino));
				}
					System.out.println("Cant Medio PAgo " + hotel1.getMedioDePagos().size());
				
				Servicio serv=new Servicio();
				serv.setNombre("wifi");
				serv.setTipoDeServicio("HO");
				hotel1.getServicios().add(serv);
				
				Servicio serv2=new Servicio();
				serv2.setNombre("pileta");
				serv2.setTipoDeServicio("HO");
				hotel1.getServicios().add(serv2);
	
				
				
//			String descripcionHab=request.getParameter("descripcionHab");	
//			String tipoHab=request.getParameter("tipoHab");
//			String cantPersonasHab=request.getParameter("cantPersonasHab");
//			String fotosHab=request.getParameter("fotosHab");
//			String serviciosHab=request.getParameter("serviciosHab");
//			Habitacion hab = new Habitacion();
//			hab.setCantPersonas(Integer.parseInt(cantPersonasHab));
//			hab.setDescripcion(descripcionHab);
//			hab.setTipo(tipoHab);
//			hab.getFotos().add(fotosHab);
//			//hab.getServicios().add(null);
//			hotel1.getHabitaciones().add(hab);
//			test test = new test();
//				test.setNombre("jony");
//				test.setApellido("ara");
				System.out.println("llego bien");
				Gson gson = new Gson();
				String jsonInString=gson.toJson(hotel1);
				System.out.println("el json Hotel: "+jsonInString);
//				ControladorHotel c = new ControladorHotel();
//				int idHotel = c.altaHotel(jsonInString);
//				System.out.println("json1");
//				ObjectMapper mapper = new ObjectMapper();		
//					System.out.println("json2");
					//Object to JSON in String
//					String jsonInString = mapper.writeValueAsString(hotel1);
					
//					String jsonInString = mapper.writeValueAsString(test);
//					System.out.println("json3");
//					Client client = Client.create();
//					String getUrl = "http://localhost:8080/JAXRS-JSON/rest/student/data/get";
//					String postUrl = "http://localhost:8080/JAXRS-JSON/rest/student/data/post";
//					WebResource webResource = client.resource(postUrl);
//					String inputData = "ACA VA EL JSON";
//					ClientResponse response = webResource.type("application/json").post(ClientResponse.class,jsonInString);
//					if(response.getStatus()!=201){
//						throw new RuntimeException("HTTP Error: "+ response.getStatus());
//					}
//					
//					String result = response.getEntity(String.class);
//					System.out.println("Response from the Server: ");
//					System.out.println(result);
				
//				System.out.println("mi JSON es: "+ jsonInString);
//				System.out.println("El id Hotel es "+String.valueOf(idHotel));
				EstablecimientoTest e = new EstablecimientoTest();
				try {
					e.hacer(jsonInString);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String jspPage = "/newBoard.jsp";
//				request.setAttribute("idHotel", String.valueOf(idHotel));
				request.setAttribute("idHotel", String.valueOf("23"));
				dispatch(jspPage, request, response);
				
			}
//			if ("AltaOferta2".equals(value)){
//				System.out.println("entro al Alta Oferta 2");
//				String idHotel = request.getParameter("selectHotel");
//				System.out.println("imprime " + idHotel);
//				ControladorHotel c = new ControladorHotel();
//				Hotel h = c.gethotel(idHotel);
//				request.setAttribute("selectHotel", idHotel);
//				request.setAttribute("hotel", h);
//				String jspPage = "/nuevaOferta2.jsp";
//				dispatch(jspPage, request, response);
//			}
//			if ("AltaOferta3".equals(value)){
//				System.out.println("entro al Alta Oferta 3");
//				System.out.println("imprime " + request.getParameter("selectHab"));
//				String nombreOferta=request.getParameter("nombreOferta");
////				String nombreHotel=request.getParameter("nombreHotel");
//				String idHab=request.getParameter("selectHab");
//				String fecDesde=request.getParameter("fecDesde");
//				String fecHasta=request.getParameter("fecHasta");
//				String precio=request.getParameter("precio");
//				String cupo=request.getParameter("cupo");
//				String estado=request.getParameter("estado");
//				String polCanc=request.getParameter("polCanc");
//				ControladorHotel c = new ControladorHotel();
//				
//				Oferta oferta = new Oferta();
//				oferta.setCupo(Integer.parseInt(cupo));
//				oferta.setEstado(estado);
//				oferta.setFechaDesde(fecDesde);
//				oferta.setFecHasta(fecHasta);
//				oferta.setPrecio(Float.parseFloat(precio));
//				oferta.setPoliticaCanc(polCanc);
////				oferta.setNombreHotel(nombreHotel);
//				oferta.setNombreOferta(nombreOferta);
//				oferta.setHabitacion(c.getHabitacion(idHab)); 
//				c.altaOferta(oferta);
//				
//				String jspPage = "/index.jsp";
//				dispatch(jspPage, request, response);
//				
//			}
//			
//			if ("AltaHabitacion".equals(value)){
//				System.out.println("entro al Alta Habitacion");
//				String descripcionHab=request.getParameter("descripcion");	
//				String tipoHab=request.getParameter("tipo");
//				String cantPersonasHab=request.getParameter("cantidad");
//				String fotosHab=request.getParameter("fotosHab");
//				String serviciosHab=request.getParameter("serviciosHab");
//				HabitacionDTO hab = new HabitacionDTO();
//				hab.setCantPersonas(Integer.parseInt(cantPersonasHab));
//				hab.setDescripcion(descripcionHab);
//				hab.setTipo(tipoHab);
//				//hab.getFotos().add(fotosHab);
//				//hab.getServicios().add(null);
//				//hotel1.getHabitaciones().add(hab);
//				
//				String idHotel=request.getParameter("idHotel");
//				System.out.println(idHotel);
//				
//				
////				ControladorHotel c = new ControladorHotel();
////				Hotel hotel=	c.gethotel(idHotel);
////				
////				System.out.println("Cargue hotel" + hotel.getId());
//				
////				List<Habitacion> habitaciones = new ArrayList<>();
////				habitaciones = hotel.getHabitaciones();
////				
////				habitaciones.add(hab);
////				hotel.getHabitaciones().add(hab);
////				
////				c.agregarHab(hotel);
//				
//				
//				Gson gson = new Gson();
//				String jsonInString=gson.toJson(hab);
//				System.out.println("el json Hab: "+jsonInString);
//				ControladorHotel c = new ControladorHotel();
//				List<Habitacion> habs = c.agregarHab(jsonInString, idHotel);
//				
//				String jspPage = "/newBoard.jsp";
//				request.setAttribute("idHotel", String.valueOf(idHotel));
//				request.setAttribute("habitaciones", habs);
//				dispatch(jspPage, request, response);
//			}
//			if ("AltaOferta1".equals(value)){
//				System.out.println("Alta oferta 1!");
//				ControladorHotel c = new ControladorHotel();
//				List<Hotel> hoteles = c.getHoteles();
//				System.out.println("algo: " + hoteles.get(0).getDescripcion());
//				request.setAttribute("hoteles", hoteles);
//				String jspPage = "/nuevaOferta1.jsp";
//				dispatch(jspPage, request, response);
//			}
			
			
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		}

}



//package Servlet;
//
//import java.io.IOException;
//import java.util.Enumeration;
//import java.util.NoSuchElementException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.sun.xml.internal.ws.api.wsdl.parser.ServiceDescriptor;
//
//import Controller.ControladorHotel;
//import Entity.EstadoHotel;
//import Entity.*;
//import Entity.MedioDePago;
//import antlr.collections.List;
//
///**
// * Servlet implementation class servlet
// */
//@WebServlet("/controlador")
//public class controlador extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public controlador() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//   
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		 String value =request.getParameter("name");
//			if ("AltaHotel".equals(value)){
//				System.out.println("entro al hotel");
//				
//				String descripcion=request.getParameter("descripcion");
//				String destino=request.getParameter("destino");
//				String direccion=request.getParameter("direccion");
//				String email=request.getParameter("email");
//				String estado=request.getParameter("estado");
//				String fotos=request.getParameter("fotos");
//				String latitud=request.getParameter("latitud");
//				String longitud=request.getParameter("longitud");
//				String medioDePagos=request.getParameter("medioDePagos");
//				String nombre=request.getParameter("nombre");
//				String servicios=request.getParameter("servicios");
//				Hotel hotel1 = new Hotel();
//				hotel1.setDescripcion(descripcion);
//				hotel1.setDestino(destino);
//				hotel1.setDireccion(direccion);
//				hotel1.setEmail(email);
//				hotel1.setEstado(EstadoHotel.P);
//				hotel1.getFotos().add(fotos);
//				hotel1.setLatitud(latitud);
//				hotel1.setLongitud(longitud);
//				hotel1.getMedioDePagos().add(MedioDePago.Tarjeta);
//				hotel1.setNombre(nombre);
//				//hotel1.setServicios(servicios);
//				
//				
//				
////				String descripcionHab=request.getParameter("descripcionHab");	
////				String tipoHab=request.getParameter("tipoHab");
////				String cantPersonasHab=request.getParameter("cantPersonasHab");
////				String fotosHab=request.getParameter("fotosHab");
////				String serviciosHab=request.getParameter("serviciosHab");
////				Habitacion hab = new Habitacion();
////				hab.setCantPersonas(Integer.parseInt(cantPersonasHab));
////				hab.setDescripcion(descripcionHab);
////				hab.setTipo(tipoHab);
////				hab.getFotos().add(fotosHab);
////				//hab.getServicios().add(null);
////				hotel1.getHabitaciones().add(hab);
//				
//				ControladorHotel c = new ControladorHotel();
//				c.altaHotel(hotel1);
//				
//				
//				
//				System.out.println("la descripes"+descripcion);
//				String jspPage = "/index.jsp";
//				dispatch(jspPage, request, response);
//
//			}
//				
//			
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		 String value =request.getParameter("name");
//			if ("AltaHotel".equals(value)){
//				System.out.println("entro al hotel");
//				
//				String descripcion=request.getParameter("descripcion");
//				String destino=request.getParameter("destino");
//				String direccion=request.getParameter("direccion");
//				String email=request.getParameter("email");
//				String estado=request.getParameter("estado");
//				String fotos=request.getParameter("fotos");
//				String latitud=request.getParameter("latitud");
//				String longitud=request.getParameter("longitud");
//				String medioDePagos=request.getParameter("medioDePagos");
//				String nombre=request.getParameter("nombre");
//				String servicios=request.getParameter("servicios");
//				Hotel hotel1 = new Hotel();
//				hotel1.setDescripcion(descripcion);
//				hotel1.setDestino(destino);
//				hotel1.setDireccion(direccion);
//				hotel1.setEmail(email);
//				hotel1.setEstado(EstadoHotel.P);
//				hotel1.getFotos().add(fotos);
//				hotel1.setLatitud(latitud);
//				hotel1.setLongitud(longitud);
//				hotel1.getMedioDePagos().add(MedioDePago.Tarjeta);
//				hotel1.setNombre(nombre);
//				//hotel1.setServicios(servicios);
//				
//				
//				
//				String descripcionHab=request.getParameter("descripcionHab");	
//				String tipoHab=request.getParameter("tipoHab");
//				String cantPersonasHab=request.getParameter("cantPersonasHab");
//				String fotosHab=request.getParameter("fotosHab");
//				String serviciosHab=request.getParameter("serviciosHab");
//				Habitacion hab = new Habitacion();
//				hab.setCantPersonas(Integer.parseInt(cantPersonasHab));
//				hab.setDescripcion(descripcionHab);
//				hab.setTipo(tipoHab);
//				hab.getFotos().add(fotosHab);
//				//hab.getServicios().add(null);
//				hotel1.getHabitaciones().add(hab);
//				
//				ControladorHotel c = new ControladorHotel();
//				c.altaHotel(hotel1);
//				
//				
//				
//				System.out.println("la descripes"+descripcion);
//				String jspPage = "/index.jsp";
//				dispatch(jspPage, request, response);
//				
//			}
//			
//			if ("AltaHabitacion".equals(value)){
//				System.out.println("entro al hab");
//				
//				String hotelId=request.getParameter("hotelId");	
//				String descripcion=request.getParameter("descripcion");	
//				String tipo=request.getParameter("tipo");
//				String cantPersonas=request.getParameter("cantPersonas");
//				String fotos=request.getParameter("fotos");
//				String servicios=request.getParameter("servicios");
//				
//				ControladorHotel c = new ControladorHotel();
//				Hotel ho=c.gethotel(hotelId);
//				Habitacion hab = new Habitacion();
//				hab.setCantPersonas(Integer.parseInt(cantPersonas));
//				hab.setDescripcion(descripcion);
//				hab.setTipo(tipo);
//				hab.getFotos().add(fotos);
//				//hab.getServicios().add(null);
//				ho.getHabitaciones().add(hab);
//			
//			}
//			
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		
//		//doGet(request, response);
//	}
//	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		RequestDispatcher rd = request.getRequestDispatcher(jsp);
//		rd.forward(request, response);
//		}
//
//}
