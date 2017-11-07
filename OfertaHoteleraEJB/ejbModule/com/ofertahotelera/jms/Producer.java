package com.ofertahotelera.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;

@Stateless
public class Producer {

	@Resource(lookup = "java:/jms/queue/testQueue")
	private Queue testQueue;

	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")
	JMSContext context;

	public void sendMessage(String messageText) {
		TextMessage message = context.createTextMessage("Hola, hay alguien ahí?");
		context.createProducer().send(testQueue, message);
	}
}
