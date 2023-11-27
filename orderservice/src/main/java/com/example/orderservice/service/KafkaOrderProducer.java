package com.example.orderservice.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.BaseDomains.dto.OrderEvent;

@Service 
public class KafkaOrderProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaOrderProducer.class);
	
	private NewTopic newTopic;
	
	private KafkaTemplate<String,OrderEvent> kafkaTemplate;

	public KafkaOrderProducer(NewTopic newTopic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
		super();
		this.newTopic = newTopic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
     public void sendMessage(OrderEvent orderEvent) {
		
		LOGGER.info(String.format("Messgage sent -> %s", orderEvent.toString()));
		
		//create msg once we log an event
		Message<OrderEvent> message = MessageBuilder
						.withPayload(orderEvent)
						.setHeader(KafkaHeaders.TOPIC, newTopic.name())
						.build();
		
		kafkaTemplate.send(message);
	}
}
