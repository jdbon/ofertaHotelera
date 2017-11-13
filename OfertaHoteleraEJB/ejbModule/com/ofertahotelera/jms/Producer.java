package com.ofertahotelera.jms;

import java.util.Properties;

import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.NamingException;

@Stateless
public class Producer {

	
	public Producer() {	}

	//String jsonS = "{\"codigo_prestador\": 999,\"nombre\": \"Dazzler\",\"destino\": \"Miami\",\"fecha_desde\": \"20180101\",\"fecha_hasta\": \"20180131\",\"cantidad_personas\": 2,\"foto_hotel\": \"http://www3.hilton.com/resources/media/hi/MLAHITW/en_US/img/shared/full_page_image_gallery/main/HL_exterior01_1270x560_FitToBoxSmallDimension_Center.jpg\",\"descripcion_hotel\": \"Descripcion Hotel\",\"lista_servicios\": [\"Wifi\", \"Frigo Bar\"],\"precio_habitacion\": 10.5,\"foto_habitacion\": \"http://www3.hilton.com/resources/media/hi/MLAHITW/en_US/img/shared/full_page_image_gallery/main/HL_exterior01_1270x560_FitToBoxSmallDimension_Center.jpg\",\"descripcion_habitacion\": \"Descripcion\",\"lista_servicios_habitacion\": [\"tele\", \"wifi\"],\"latitud\": -34.606299,\"longitud\": -58.364667,\"politica_cancelacion\": \"Politica de cancelacion\",\"medio_pago_hotel\": [1,2,3],\"email_hotel\": \"\",\"cupo\": 100}";
	String messageToSend = "Hola, llego msg";
	Context context;

	final Properties env = new Properties();
	    
	public void createCola(String jsonS) throws NamingException, JMSException{
//	      env.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
//        env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, "http-remoting://192.168.1.69:8080"));
//        env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", "hotel"));
//        env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", "hotel"));
//        context = new InitialContext(env);
//
//        // Perform the JNDI lookups
//        String connectionFactoryString = System.getProperty("connection.factory", "jms/RemoteConnectionFactory");
//        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);
//
//        String destinationString = System.getProperty("destination", "jms/queue/ofertahotelera");
//        Destination destination = (Destination) context.lookup(destinationString);
//
//        // Create the JMS connection, session, producer, and consumer
//        Connection connection = connectionFactory.createConnection(System.getProperty("username", "hotel"), System.getProperty("password", "hotel"));
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//       // consumer = session.createConsumer(destination);
//        connection.start();
	    	
//		// crear un producer para enviar mensajes usando la session
//		MessageProducer producer = session.createProducer(destination);
	    	
//		// crear un mensaje de tipo text y setearle el contenido
//		TextMessage message = session.createTextMessage();
//		message.setText(jsonS);
	    	
//		// enviar el mensaje
//		producer.send(message);
	    	
//		// recordar cerrar la session y la connection en un bloque “finally”
//		connection.close();
	    }

} 

