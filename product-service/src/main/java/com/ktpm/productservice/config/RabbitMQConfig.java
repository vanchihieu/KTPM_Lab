//package com.ktpm.productservice.config;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfig {
//
//    public static final String ORDER_EXCHANGE = "order_exchange";
//    public static final String ORDER_CREATED_QUEUE = "order_created_queue";
//    public static final String ORDER_CANCELLED_QUEUE = "order_cancelled_queue";
//    public static final String ORDER_CREATED_ROUTING_KEY = "order.created";
//    public static final String ORDER_CANCELLED_ROUTING_KEY = "order.cancelled";
//
//    @Bean
//    public TopicExchange orderExchange() {
//        return new TopicExchange(ORDER_EXCHANGE);
//    }
//
//    @Bean
//    public Queue orderCreatedQueue() {
//        return new Queue(ORDER_CREATED_QUEUE, true);
//    }
//
//    @Bean
//    public Queue orderCancelledQueue() {
//        return new Queue(ORDER_CANCELLED_QUEUE, true);
//    }
//
//    @Bean
//    public Binding orderCreatedBinding(Queue orderCreatedQueue, TopicExchange orderExchange) {
//        return BindingBuilder.bind(orderCreatedQueue).to(orderExchange).with(ORDER_CREATED_ROUTING_KEY);
//    }
//
//    @Bean
//    public Binding orderCancelledBinding(Queue orderCancelledQueue, TopicExchange orderExchange) {
//        return BindingBuilder.bind(orderCancelledQueue).to(orderExchange).with(ORDER_CANCELLED_ROUTING_KEY);
//    }
//
//    @Bean
//    public MessageConverter messageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(messageConverter());
//        return template;
//    }
//}