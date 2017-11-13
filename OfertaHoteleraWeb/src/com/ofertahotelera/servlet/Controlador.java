package com.ofertahotelera.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ofertahotelera.dto.ColaDTO;
import com.ofertahotelera.dto.EstadoHotelDTO;
import com.ofertahotelera.dto.HabitacionDTO;
import com.ofertahotelera.dto.HotelDTO;
import com.ofertahotelera.dto.MedioDePagoDTO;
import com.ofertahotelera.dto.OfertaDTO;
import com.ofertahotelera.dto.ServicioDTO;
import com.ofertahotelera.integracion.InterfacesBO;
import com.ofertahotelera.jms.Producer;
import com.ofertahotelera.resource.EstablecimientoClient;
import com.ofertahotelera.resource.OfertaClient;
import com.ofertahotelera.util.Utility;


/**
 * Servlet implementation class servlet
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static OfertaClient ofertaClient= OfertaClient.getInstancia();
	private static InterfacesBO interfaz = InterfacesBO.getInstancia();
	EstablecimientoClient establecimiento = EstablecimientoClient.getInstancia();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
    }
    
	@EJB
	Producer producer;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String value =request.getParameter("name");
		 
		 if ("ObtenerServicios".equals(value)){
			 
			 	System.out.println("Obtener Servicios Hotel");
				String json = "{ \"nombre\" : \"Hotel\" }";
				List<String> nombresServicios =new ArrayList<>();
				nombresServicios = interfaz.obtenerServiciosPorTipo(json,"Hotel");
				
				
				
//				Gson gson = new Gson();
//				List listado = gson.fromJson(servicios, new TypeToken<List>(){}.getType());
//				
//				List<String> nombresServicios = new ArrayList<>();
//				for (int i = 0; i < listado.size(); i++) {
////					System.out.println(listado.get(i));
//					String[] listaString = listado.get(i).toString().split(",");
//					for (int j = 0; j < listaString.length; j++) {
////						System.out.println(listaString[j]);
//						if(listaString[j].contains("nombre")&&!listaString[j].contains("Hotel")) {
//							System.out.println(listaString[j].substring(8));
//							nombresServicios.add(listaString[j].substring(8));
//						}
//					}
//				}
//				
				String jsonLog = "{ \"plataformaEnvia\":\"OH\", \"plataformaRecibe\":\"BO\", \"servicio\":\"Get Servicio Hotel\", \"observacion\":\"SUCCESS\" }";
				establecimiento.grabarLog(jsonLog);

				
				
				String jspPage = "/nuevoEstablecimiento.jsp";
				request.setAttribute("nombresServicios", nombresServicios);
				dispatch(jspPage, request, response);
		 }
			if ("AltaHotel".equals(value)){
				System.out.println("entro al Alta Hotel");
				
				String descripcion=request.getParameter("descripcion");
				String destino=request.getParameter("selectDestino");
				String direccion=request.getParameter("direccion");
				String email=request.getParameter("email");
				//String estado=request.getParameter("estado");
//				String fotos=request.getParameter("fotos");
				String latitud=request.getParameter("latitud");
				String longitud=request.getParameter("longitud");
//				String medioDePagos=request.getParameter("medioDePagos");
				String nombre=request.getParameter("nombre");
				//String servicios=request.getParameter("servicios");
				String foto=request.getParameter("selectFoto");
				
				String tarjeta=request.getParameter("Tarjeta");
				String cheque=request.getParameter("Cheque");
				String Mercado_Pago=request.getParameter("Mercado_Pago");
				String PayPal=request.getParameter("PayPal");
				String Pago_en_Destino=request.getParameter("Pago_en_Destino");
				
				int cantServ=Integer.parseInt(request.getParameter("cantServ"));
				
				String miIP=Utility.getHostAddress();
				System.out.println("mi foto "+ foto);
				System.out.println("mi ip: "+ miIP);
				System.out.println("mi url es: ");
				String urlFoto=miIP+"/ofertaHotelera/fotos-Hotel/"+foto;
				//System.out.println(miIP+"/ofertaHotelera/fotos-Hotel/"+foto);
				System.out.println(urlFoto);
		
				
				HotelDTO hotel1 = new HotelDTO();
				hotel1.setDescripcion(descripcion);

				hotel1.setDestino(destino);
				hotel1.setDireccion(direccion);
				hotel1.setEmail(email);
				//hotel1.setEstado(EstadoHotelDTO.P);
//				hotel1.getFotos().add("foo foto foto");
//				hotel1.getFotos().add("sahfjafkljdljd");
				hotel1.setLatitud(Double.parseDouble(latitud));
				hotel1.setLongitud(Double.parseDouble(longitud));
				hotel1.setFoto(urlFoto);
//				hotel1.setMedioDePagos(MedioDePago.Tarjeta);
				//hotel1.setId(999);
				//hotel1.getMedioDePagos().add(MedioDePago.Tarjeta);
//				hotel1.getMedioDePagos().add(MedioDePago.valueOf(medioDePagos));
//				System.out.println(MedioDePago.valueOf(medioDePagos));
				hotel1.setNombre(nombre);
				System.out.println("Cantidad de servervios Hotel: "+cantServ);
				for (int j = 0; j < cantServ; j++) {
					System.out.println("Checkbox "+request.getParameter(String.valueOf(j)));
					if (request.getParameter(String.valueOf(j)) != null) {
						ServicioDTO serv=new ServicioDTO();
						serv.setNombre(request.getParameter(String.valueOf(j)));
						serv.setTipoDeServicio("HO");
						hotel1.getServicios().add(serv);
					}
					
				}
				
				
				
				System.out.println(tarjeta);
				System.out.println(cheque);
				System.out.println(Mercado_Pago);
				System.out.println(PayPal);
				System.out.println(Pago_en_Destino);
				
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
				
//				Servicio serv=new Servicio();
//				serv.setNombre("wifi");
//				serv.setTipoDeServicio("HO");
//				hotel1.getServicios().add(serv);
//				
//				Servicio serv2=new Servicio();
//				serv2.setNombre("pileta");
//				serv2.setTipoDeServicio("HO");
//				hotel1.getServicios().add(serv2);
	
				
				
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
//				EstablecimientoClient e = new EstablecimientoClient();
				
				int idHotel = 0;
				try {
					idHotel = establecimiento.altaHotel(jsonInString);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				String jspPage = "/nuevaHabitacion.jsp";
				System.out.println("Id hotel: "+idHotel);
				
				System.out.println("Obtener Servicios Habitacion");
				String json = "{ \"nombre\" : \"Habitacion\" }";
				List<String> nombresServicios =new ArrayList<>();
				nombresServicios = interfaz.obtenerServiciosPorTipo(json,"Habitacion");
				
				
				String jsonLog = "{ \"plataformaEnvia\":\"OH\", \"plataformaRecibe\":\"BO\", \"servicio\":\"Get Servicio Habitacion\", \"observacion\":\"SUCCESS\" }";
				establecimiento.grabarLog(jsonLog);
				request.setAttribute("serviciosHab",nombresServicios);
				request.setAttribute("nombre", hotel1.getNombre());
				request.setAttribute("idHotel", String.valueOf(idHotel));
				
				dispatch(jspPage, request, response);
				
			}
			
			if ("AltaHabitacion".equals(value)){
				System.out.println("entro al Alta Habitacion");
				String descripcionHab=request.getParameter("descripcion");	
				String tipoHab=request.getParameter("tipo");
				String cantPersonasHab=request.getParameter("cantidad");
			//	String fotosHab=request.getParameter("fotosHab");
			//	String serviciosHab=request.getParameter("serviciosHab");
				int cantServ=Integer.parseInt(request.getParameter("cantServ"));
				String foto=request.getParameter("selectFoto");
				
				HabitacionDTO hab = new HabitacionDTO();
				hab.setCantPersonas(Integer.parseInt(cantPersonasHab));
				hab.setDescripcion(descripcionHab);
				hab.setTipo(tipoHab);
				
				
				String miIP=Utility.getHostAddress();
				System.out.println("mi foto "+ foto);
				System.out.println("mi ip: "+ miIP);
				System.out.println("mi url es: ");
				String urlFoto=miIP+"/ofertaHotelera/fotos-Habitacion/"+foto;
				//System.out.println(miIP+"/ofertaHotelera/fotos-Hotel/"+foto);
				System.out.println(urlFoto);
				
				
				
				hab.setFoto(urlFoto);
				//hab.getFotos().add(fotosHab);
				//hab.getServicios().add(null);
				//hotel1.getHabitaciones().add(hab);
				
				String idHotel=request.getParameter("idHotel");
				System.out.println("Mi id hotel "+idHotel);
				
				System.out.println("Cantidad de servervios Hab: "+cantServ);
				for (int j = 0; j < cantServ; j++) {
					System.out.println("Checkbox "+request.getParameter(String.valueOf(j)));
					if (request.getParameter(String.valueOf(j)) != null) {
						ServicioDTO serv=new ServicioDTO();
						serv.setNombre(request.getParameter(String.valueOf(j)));
						serv.setTipoDeServicio("HA");
						hab.getServicios().add(serv);
					}
					
				}
				
				
//				ControladorHotel c = new ControladorHotel();
//				Hotel hotel=	c.gethotel(idHotel);
//				
//				System.out.println("Cargue hotel" + hotel.getId());
				
//				List<Habitacion> habitaciones = new ArrayList<>();
//				habitaciones = hotel.getHabitaciones();
//				
//				habitaciones.add(hab);
//				hotel.getHabitaciones().add(hab);
//				
//				c.agregarHab(hotel);
				
				
				Gson gson = new Gson();
				String jsonInString=gson.toJson(hab);
				System.out.println("el json Hab: "+jsonInString);
//				ControladorHotel c = new ControladorHotel();
//				List<Habitacion> habs = c.agregarHab(jsonInString, idHotel);
				
				String listhab="";

				try {
					listhab=establecimiento.agregarHab(jsonInString, idHotel);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				List<HabitacionDTO> habs = gson.fromJson(listhab, new TypeToken<List<HabitacionDTO>>(){}.getType());
				
				String nombreHotel = request.getParameter("nombre");
				System.out.println("Obtener Servicios Habitacion");
				String json = "{ \"nombre\" : \"Habitacion\" }";
				List<String> nombresServicios =new ArrayList<>();
				nombresServicios = interfaz.obtenerServiciosPorTipo(json,"Habitacion");
				
				request.setAttribute("serviciosHab",nombresServicios);
				request.setAttribute("nombre", nombreHotel);
				
				String jspPage = "/nuevaHabitacion.jsp";
				request.setAttribute("idHotel", String.valueOf(idHotel));
				request.setAttribute("habitaciones", habs);
				dispatch(jspPage, request, response);
			}
			if ("EnviarSolicitud".equals(value)){
				System.out.println("Enviar Solitud");
				String nombreHotel = request.getParameter("nombre");
				String idHotel = request.getParameter("idHotel");
				String solicitud = "{ \"tipo\" : \"Hotelera\", \"detalle\" :\"" + nombreHotel + "\" }";
				establecimiento.enviarSolicitud(solicitud,idHotel);
				
				
				String jsonLog = "{ \"plataformaEnvia\":\"OH\", \"plataformaRecibe\":\"BO\", \"servicio\":\"Alta Establecimiento\", \"observacion\":\"SUCCESS\" }";
				establecimiento.grabarLog(jsonLog);
				String jspPage = "/index.jsp";
				dispatch(jspPage, request, response);
			}
			
			if ("AltaOferta1".equals(value)){
				System.out.println("Alta oferta 1!");
				
				String hoteles = establecimiento.getHotelesActivos();
				System.out.println(hoteles);
				Gson gson = new Gson();
				List<HotelDTO> hotels = gson.fromJson(hoteles, new TypeToken<List<HotelDTO>>(){}.getType());
				request.setAttribute("hoteles", hotels);
				String jspPage = "/nuevaOferta1.jsp";
				dispatch(jspPage, request, response);
			}
			if ("AltaOferta2".equals(value)){
				System.out.println("entro al Alta Oferta 2");
				String idHotel = request.getParameter("selectHotel");
				System.out.println("imprime " + idHotel);
				String hotel = establecimiento.getHotel(idHotel);
				HotelDTO h = new HotelDTO();
				Gson gson = new Gson();
				h=gson.fromJson(hotel, HotelDTO.class);
				
				String estadoHo = EstadoHotelDTO.Pendiente.toString();
				
				if (h.getEstado()==EstadoHotelDTO.Pendiente)
				{
					///chequear con SOap si el hotel esta aprobado y actualizar la bbase
					// actualziar el estado
					
					String jsonLog = "{ \"plataformaEnvia\":\"OH\", \"plataformaRecibe\":\"BO\", \"servicio\":\"Prestador Autorizado\", \"observacion\":\"SUCCESS\" }";
					establecimiento.grabarLog(jsonLog);
					
							
				}
				
				if (h.getEstado()==EstadoHotelDTO.Aprobado ||  estadoHo==EstadoHotelDTO.Aprobado.toString()) {
				
				request.setAttribute("selectHotel", idHotel);
				request.setAttribute("hotel", h);
				String jspPage = "/nuevaOferta2.jsp";
				dispatch(jspPage, request, response);
				}else {
					System.out.println("Hotel invalido");
					String jspPage ="/OfertaHoteleraWeb/Controlador?name=AltaOferta1";
					dispatch(jspPage, request, response);				
					}
			}
			if ("AltaOferta3".equals(value)){
				System.out.println("entro al Alta Oferta 3");
				System.out.println("imprime " + request.getParameter("selectHab"));
				String nombreOferta=request.getParameter("nombreOferta");
				String nombreHotel=request.getParameter("nombreHotel");
				String idHab=request.getParameter("selectHab");
				String fecDesde=request.getParameter("fecDesde");
				String fecHasta=request.getParameter("fecHasta");
				String precio=request.getParameter("precio");
				String cupo=request.getParameter("cupo");
				String estado=request.getParameter("selectEstado");
				String polCanc=request.getParameter("polCanc");
				
				
				OfertaDTO oferta = new OfertaDTO();
				oferta.setCupo(Integer.parseInt(cupo));
				oferta.setEstado(estado);
				oferta.setFechaDesde(fecDesde);
				oferta.setFecHasta(fecHasta);
				oferta.setPrecio(Float.parseFloat(precio));
				oferta.setPoliticaCanc(polCanc);
				oferta.setNombreHotel(nombreHotel);
				oferta.setNombreOferta(nombreOferta);
				
				Gson gson = new Gson();				
				String ofertaJson = gson.toJson(oferta);
				System.out.println("json oferta: "+ ofertaJson);
				ofertaClient.altaOferta(ofertaJson,idHab);
				
				String hotelJson = establecimiento.getHotelByHab(idHab);
				Gson gson2 = new Gson();
				HotelDTO hotelDTO = gson2.fromJson(hotelJson, HotelDTO.class);
				int codigo_prestador = hotelDTO.getIdBO();
				String nombre = hotelDTO.getNombre();
				String destino = hotelDTO.getDestino();
				String fdesde = oferta.getFechaDesde();
				String fhasta = oferta.getFecHasta();
				String foto = hotelDTO.getFoto();
				String descripcion = hotelDTO.getDescripcion();
				List<ServicioDTO> servicios = hotelDTO.getServicios();
				
				List<String> listaServicios = new ArrayList<>();
				for (int i = 0; i < servicios.size(); i++) {
					listaServicios.add(servicios.get(i).getNombre());
				}
				float precioOferta = oferta.getPrecio();
				
				List<HabitacionDTO> habitaciones = hotelDTO.getHabitaciones();
				HabitacionDTO habDTO = null;
				for (int i = 0; i < habitaciones.size(); i++) {
					HabitacionDTO habitacionDTO = habitaciones.get(i);
					if(habitacionDTO.getId() == Integer.parseInt(idHab)) {
						habDTO = habitacionDTO;
						i = habitaciones.size();
					}
				}

				int cantPersonas = habDTO.getCantPersonas();
				String fotoHab = habDTO.getFoto();
				String descripcionHab = habDTO.getDescripcion();
				
				List<String> listaServiciosHab = new ArrayList<>();
				for (int i = 0; i < habDTO.getServicios().size(); i++) {
					listaServiciosHab.add(habDTO.getServicios().get(i).getNombre());
				}
				
				double lat = hotelDTO.getLatitud();
				double longi = hotelDTO.getLongitud();
				String politica = oferta.getPoliticaCanc();
				
				List<Integer> mediosDePago = new ArrayList<>();
				for (int i = 0; i < hotelDTO.getMedioDePagos().size(); i++) {
					int mpVal = hotelDTO.getMedioDePagos().get(i).getValue();
					System.out.println(mpVal);
					mediosDePago.add(mpVal);
				}
				String email = hotelDTO.getEmail();
				int cupoOferta = oferta.getCupo();
				
				ColaDTO colaDTO = new ColaDTO( codigo_prestador,  nombre,  destino,  fdesde,  fhasta,  foto,
						 descripcion, listaServicios,  precioOferta,  cantPersonas,  fotoHab,
						 descripcionHab, listaServiciosHab,  lat,  longi,  politica,
						mediosDePago,  email,  cupoOferta);
				String jsonS = gson.toJson(colaDTO);
				System.out.println(jsonS);
				
				try {
					producer.createCola(jsonS);
				} catch (NamingException e) {
					e.printStackTrace();
				} catch (JMSException e) {
					e.printStackTrace();
				}
				
				String jsonLog = "{ \"plataformaEnvia\":\"OH\", \"plataformaRecibe\":\"PW\", \"servicio\":\"Crear Oferta\", \"observacion\":\"SUCCESS\" }";
				establecimiento.grabarLog(jsonLog);
				
				String jspPage = "/index.jsp";
				dispatch(jspPage, request, response);
				
			}
			
			
			
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		}

}

