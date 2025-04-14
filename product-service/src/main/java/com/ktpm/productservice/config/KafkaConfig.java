package com.ktpm.productservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Value("${kafka.topic.order-created}")
    private String orderCreatedTopic;

    @Value("${kafka.topic.order-cancelled}")
    private String orderCancelledTopic;
    
    @Bean
    public NewTopic orderCreatedTopic() {
        return TopicBuilder.name(orderCreatedTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }
    
    @Bean
    public NewTopic orderCancelledTopic() {
        return TopicBuilder.name(orderCancelledTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }
}