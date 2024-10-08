package com.blackbird.organizationservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    private final String TOPIC_NAME = "organization_topic";

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(TOPIC_NAME).build();
    }
}
