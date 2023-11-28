package com.example.rabbit.demorabbit.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    //rabbitlistener will read n consue the msg from the queu
	@RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){
        LOGGER.info(String.format("Received message -> %s", message));
    }

}
