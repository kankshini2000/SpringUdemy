package com.example.emailservice.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.BaseDomains.dto.OrderEvent;

@Service
public class OrderConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
	
	@KafkaListener(topics = "${spring.kafka.topic.name}" , groupId = "${spring.kafka.consumer.group-id}")
	public void kafkaConsumerForOrder(OrderEvent orderEvent) {
		
		LOGGER.info(String.format("Order received in the email service => %s", orderEvent.toString()));
	}
}
