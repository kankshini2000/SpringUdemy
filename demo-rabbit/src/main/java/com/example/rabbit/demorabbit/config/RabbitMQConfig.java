package com.example.rabbit.demorabbit.config;

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

	//this is configuration class 
	//value to read the "java" value form the porperties file n then pass that value
	 @Value("${rabbitmq.queue.name}")
	 private String queue;
	
	  @Value("${rabbitmq.queue.json.name}")
	    private String jsonQueue;
	 
     @Value("${rabbitmq.exchange.name}")
     private String exchange;
	 
     @Value("${rabbitmq.routing.key}")
     private String routingKey;

     @Value("${rabbitmq.routing.json.key}")
     private String routingJsonKey;
	 
   /*spring bean for rabbitMq queue
 	we r making this quuqe name as configurable */
	 @Bean
	 public Queue queue(){
		return new Queue(queue);
	}
	 
	 @Bean
	    public Queue jsonQueue(){
	        return new Queue(jsonQueue);
	    }
	
	@Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }
	
	/*we need to bind the queue with the exechange method using routing key
	binded queu to exchange with routing key*/
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue())
				.to(exchange())
				.with(routingKey);
	}
	
	//bind between json queue to echanges using routing_json_key
	@Bean
    public Binding jsonBinding(){
        return BindingBuilder
                .bind(jsonQueue())
                .to(exchange())
                .with(routingJsonKey);
    }
	
	/*spring boot autoconfiguration we automatically configure the infr
	 * beans connectionfactor, rabbitemplate,rabitadmin */
	
	//need to create spring bean for messageconverter to support to send a JSON msgg.
	  @Bean
	    public MessageConverter converter(){
	        return new Jackson2JsonMessageConverter();
	    }
	  
	  //configure rabbitemplate n set the mesgconverter to rabbittemplate
	  @Bean
	    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
	        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	        rabbitTemplate.setMessageConverter(converter());
	        return rabbitTemplate;
	    }
}
