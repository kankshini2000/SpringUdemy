package com.example.rabbit.demorabbit.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.rabbit.demorabbit.dto.User;

@Service
public class RabbitMQJsonConsumer {
	//logic to consume the json msg from the exchange
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

	//listen to a particular quqe
    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(User user){
        LOGGER.info(String.format("Received JSON message -> %s", user.toString()));
    }

}
