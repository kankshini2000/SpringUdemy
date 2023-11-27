package com.example.kafkatut.demokakfkas.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.example.kafkatut.demokakfkas.payload.User;

@Service
public class JsonKafkaProducer {
	
	 @Value("${spring.kafka.topic-json.name}")
	    private String topicJsonName;
	 
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	//we r gonna pass User object as abyte hence gonna use Userclass as a value type
	private KafkaTemplate<String, User> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User data){

        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        //creation of msgobject n send using kafka template object
        //her java_json means that we have created a speaprte topic to store json messges
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();
        kafkaTemplate.send(message);
    }
	
	
}
