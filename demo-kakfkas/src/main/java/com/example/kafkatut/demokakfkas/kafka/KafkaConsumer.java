package com.example.kafkatut.demokakfkas.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
      //consume mesgs form th particualr kakfa topic
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	
	//here groupid is the consumer id provided in the applciation.properties
    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));
    }
    /* so this consume method acts as a subscriber and it it sucbscribed to the java 
     * so whenever the kafkas producer will send a message to the kafka topic then this consume method/subscriber method wi
     will receieved the message from teh "JAVA" kafka topic.
    */
}
