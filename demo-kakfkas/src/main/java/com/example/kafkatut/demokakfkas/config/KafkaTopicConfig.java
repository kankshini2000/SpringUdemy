package com.example.kafkatut.demokakfkas.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	@Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;
	
	@Bean
	public NewTopic javaguideTopic() {
		return TopicBuilder.name("java").build();		
	}
	
	@Bean
	public NewTopic javaguideJsonTopic() {
		return TopicBuilder.name("java_json").build();		
	}
	
}
