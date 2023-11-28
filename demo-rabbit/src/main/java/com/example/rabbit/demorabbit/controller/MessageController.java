package com.example.rabbit.demorabbit.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbit.demorabbit.publisher.RabbitMQProducer;

@RestController
@RequestMapping("/api/v1")
//this spring bean has only one constructore hence one paratmerized constritor
public class MessageController {
	
	private RabbitMQProducer producer;

	public MessageController(RabbitMQProducer producer) {
		this.producer = producer;
	}
	

	//http://localhost
   @GetMapping("/publish")
   //we are gonna pass the msg in the url by query parameter
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    } 
	
	
}
