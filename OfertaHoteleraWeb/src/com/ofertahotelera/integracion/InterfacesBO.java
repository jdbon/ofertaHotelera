package com.ofertahotelera.integracion;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ofertahotelera.resource.EstablecimientoClient;
import com.ofertahotelera.rest.EstablecimientoServiceBeanRemote;

public class InterfacesBO {
	private static InterfacesBO instance = null;
		
	protected InterfacesBO() {
		super();
	}
	
	public static InterfacesBO getInstancia() {
		if (instance == null) {
			instance = new InterfacesBO();
		}
		return instance;
	}
	public String enviarSolicitudBO(String solicitud) throws Exception {
//		URL url = new URL("http://192.168.1.92:8080/TPO_BO_WEB/rest/ServiciosBO/EnviarSolicitud");
//		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//		urlConnection.setDoOutput(true);
//		urlConnection.setRequestMethod("POST");
//		urlConnection.setRequestProperty("Content-Type", "application/json");
//		
//		
//		IOUtils.write(solicitud, urlConnection.getOutputStream());
//		String response2 = IOUtils.toString(urlConnection.getInputStream());
//		System.out.println(response2);
//		return response2;
		System.out.println("entre a interfacesBO");
		String response2 = "{\"id\":18,\"detalle\":\"Hotel NH\",\"tipo\":\"Hotelera\",\"estado\":\"Pendiente\"}";
		return response2;
	}
	
	public List<String> obtenerServiciosPorTipo(String json,String tipo) {
//		url = new URL("http://192.168.1.92:8080/TPO_BO_WEB/rest/ServiciosBO/GetServiciosPorTipo");
//		urlConnection = (HttpURLConnection) url.openConnection();
//		urlConnection.setDoOutput(true);
//		urlConnection.setRequestMethod("POST");
//		urlConnection.setRequestProperty("Content-Type", "application/json");
//		
//		
//		
//		IOUtils.write(json, urlConnection.getOutputStream());
//		String response4 = IOUtils.toString(urlConnection.getInputStream());
//		System.out.println(response4);
		
		// Respuesta en response4:
		String response4="";
		if(tipo=="Hotel") {
			
		response4 = "[{\"id\":1,\"nombre\":\"Piscina\",\"tipo\":{\"id\":1,\"nombre\":\"Hotel\",\"servicios\":[]}},{\"id\":2,\"nombre\":\"Restaurante\",\"tipo\":{\"id\":1,\"nombre\":\"Hotel\",\"servicios\":[]}},{\"id\":3,\"nombre\":\"Gimnasio\",\"tipo\":{\"id\":1,\"nombre\":\"Hotel\",\"servicios\":[]}}]";
		
		}
		if(tipo=="Habitacion") {		
			//response4 ="[{\"id\":1,\"tipo\":{\"id\":1,\"nombre\":\"Habitacion\"},\"nombre\":\"wifi\"},{\"id\":2,\"tipo\":{\"id\":1,\"nombre\":\"Habitacion\"},\"nombre\":\"despertador\"},{\"id\":3,\"tipo\":{\"id\":1,\"nombre\":\"Habitacion\"},\"nombre\":\"minibar\"}]";
			response4 = "[{\"id\":1,\"nombre\":\"Piscina\",\"tipo\":{\"id\":1,\"nombre\":\"Habitacion\",\"servicios\":[]}},{\"id\":2,\"nombre\":\"Restaurante\",\"tipo\":{\"id\":1,\"nombre\":\"Habitacion\",\"servicios\":[]}},{\"id\":3,\"nombre\":\"Gimnasio\",\"tipo\":{\"id\":1,\"nombre\":\"Habitacion\",\"servicios\":[]}}]";
			
		}
		System.out.println("Respuesto BO servicios"+response4);
		
		Gson gson = new Gson();
		List listado = gson.fromJson(response4, new TypeToken<List>(){}.getType());
		
		List<String> nombresServicios = new ArrayList<>();
		for (int i = 0; i < listado.size(); i++) {
//			System.out.println(listado.get(i));
			String[] listaString = listado.get(i).toString().split(",");
			for (int j = 0; j < listaString.length; j++) {
//				System.out.println(listaString[j]);
				if(listaString[j].contains("nombre")&&!listaString[j].contains(tipo)) {
					System.out.println(listaString[j].substring(8));
					nombresServicios.add(listaString[j].substring(8));
				}
			}
		}
		
		
		return nombresServicios;
	}
	
	
	public void enviarLog(String log) throws Exception {
//		URL url = new URL("http://192.168.1.92:8080/TPO_BO_WEB/rest/ServiciosBO/RegistrarLog");
//		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//		urlConnection.setDoOutput(true);
//		urlConnection.setRequestMethod("POST");
//		urlConnection.setRequestProperty("Content-Type", "application/json");
//		
//		
//		
//		
//		IOUtils.write(log, urlConnection.getOutputStream());
//		String response3 = IOUtils.toString(urlConnection.getInputStream());
//		System.out.println(response3);
		
		
		// Respuesta en response3
		// {"id":19,"plataformaEnvia":"PW","plataformaRecibe":"OH","fecha":1510424259850,"servicio":"Crear oferta hotelera","observacion":null}
		
		
	
	}

}
