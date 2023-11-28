package com.example.rabbit.demorabbit.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
	
	//fetch exchange n routing key value frm app.propeties
	    @Value("${rabbitmq.exchange.name}")
	    private String exchange;

	    @Value("${rabbitmq.routing.key}")
	    private String routingKey;
	    
	    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);
	    
	    private RabbitTemplate rabbitTemplate;

		public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
			this.rabbitTemplate = rabbitTemplate;
		}
	    
	  public void sendMessage(String message){
	        LOGGER.info(String.format("Message sent -> %s", message));
	        /*send msg to the particular queue
	        convert an dsend to sent the msg to the exchange , n exchange uses 
	        routing key to route this msg to queue*/
	        rabbitTemplate.convertAndSend(exchange, routingKey, message);
	    }
}
