package com.ktpm.orderservice.event;

import com.ktpm.orderservice.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderEventPublisher {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;
    
    @Value("${kafka.topic.order-created}")
    private String orderCreatedTopic;
    
    @Value("${kafka.topic.order-cancelled}")
    private String orderCancelledTopic;

    public void publishOrderCreatedEvent(Order order) {
        OrderCreatedEvent event = mapToOrderCreatedEvent(order);
        
        log.info("Publishing order created event for order ID: {}", order.getId());
        kafkaTemplate.send(orderCreatedTopic, event);
    }

    public void publishOrderCancelledEvent(Order order) {
        OrderCreatedEvent event = mapToOrderCreatedEvent(order);
        
        log.info("Publishing order cancelled event for order ID: {}", order.getId());
        kafkaTemplate.send(orderCancelledTopic, event);
    }

    private OrderCreatedEvent mapToOrderCreatedEvent(Order order) {
        return OrderCreatedEvent.builder()
                .orderId(order.getId())
                .customerId(order.getCustomerId())
                .orderDate(order.getOrderDate())
                .orderStatus(order.getOrderStatus())
                .totalAmount(order.getTotalAmount())
                .orderItems(order.getOrderItems().stream()
                        .map(orderItem -> OrderCreatedEvent.OrderItemDto.builder()
                                .productId(orderItem.getProductId())
                                .quantity(orderItem.getQuantity())
                                .price(orderItem.getPrice())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}