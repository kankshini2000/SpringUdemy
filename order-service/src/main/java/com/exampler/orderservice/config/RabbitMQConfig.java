package com.exampler.orderservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	 @Value("${rabbitmq.queue.order.name}")
	    private String orderQueue;
	
	 @Value("${rabbitmq.queue.email.name}")
	    private String emailQueue;
	 
	 @Value("${rabbitmq.exchange.name}")
	    private String exchange;
	 
	 @Value("${rabbitmq.binding.routing.key}")
	    private String orderRoutingKey;
	 
	 
	  @Value("${rabbitmq.binding.email.routing.key}")
	    private String emailRoutingKey;
	  
	 //sprin bean for que- order n email
	@Bean
    public Queue orderQueue(){
        return new Queue(orderQueue);
    }
	
	// spring bean for queue - order queue
    @Bean
    public Queue emailQueue(){
        return new Queue(emailQueue);
    }
	
	//sprin bean for exchange
	 @Bean
	    public TopicExchange exchange(){
	        return new TopicExchange(exchange);
	    }
	 
	
	//sprin for bind betwe exchange n que using route key
	 @Bean
	    public Binding binding(){
	        return BindingBuilder
	                .bind(orderQueue())
	                .to(exchange())
	                .with(orderRoutingKey);
	    }
	 
	// spring bean for binding between exchange and queue using routing key
	    @Bean
	    public Binding emailBinding(){
	        return BindingBuilder
	                .bind(emailQueue())
	                .to(exchange())
	                .with(emailRoutingKey);
	    }
	
	//msg converter
	  @Bean
	    public MessageConverter converter(){
	        return new Jackson2JsonMessageConverter();
	    }
	 
	//configure rabbit template
	  //Amqp is an interface n this rabbittempalte implents this Ampqp interface
	  @Bean
	    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
	        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	       //set msg converter Jaackson to JSON msg converter
	        rabbitTemplate.setMessageConverter(converter());
	        return rabbitTemplate;
	    }
	  
}
