package com.example.orderservice.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BaseDomains.dto.Order;
import com.example.BaseDomains.dto.OrderEvent;
import com.example.orderservice.service.KafkaOrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	private KafkaOrderProducer kafkaOrderProducer;

	public OrderController(KafkaOrderProducer kafkaOrderProducer) {
		super();
		this.kafkaOrderProducer = kafkaOrderProducer;
	}
	
	@PostMapping("/orders")
	//convert json into java bejct
	public String placeOrder(@RequestBody Order order) {
		order.setOrderId(UUID.randomUUID().toString());
		OrderEvent event = new OrderEvent();
		event.setMessage("Order is in pending state");
		event.setStatus("PENDING");
		event.setOrder(order);
		
		kafkaOrderProducer.sendMessage(event);
		
		return "Order placed succesfully!......";
		
	}

}
