package com.example.kafkatut.demokakfkas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkatut.demokakfkas.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
	
	private KafkaProducer kafkaProducer;
	
	//http://localhost:8080/api/v1/kafka/publish?message=helloworld
	public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

	/*in order to check whether you message has been sent to the topic or not
	 * here --topic (jave) is the message which you have provided in the main class
	 * hit C: \kafka>. \bin\windows\kafka-console-consumer.bat -- topic java -- f
rom-beginning -- bootstrap-server localhost: 9092
helloworld*/
	
    // http:localhost:1111/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
