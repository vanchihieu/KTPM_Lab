package com.ktpm.productservice.event;

import com.ktpm.productservice.model.Product;
import com.ktpm.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderEventListener {

    private final ProductRepository productRepository;

    @KafkaListener(topics = "${kafka.topic.order-created}", groupId = "${spring.kafka.consumer.group-id}")
    @Transactional
    public void handleOrderCreatedEvent(OrderEvent orderEvent) {
        log.info("Received order created event for order ID: {}", orderEvent.getOrderId());
        
        // Update product inventory for each order item
        orderEvent.getOrderItems().forEach(orderItem -> {
            Product product = productRepository.findById(orderItem.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + orderItem.getProductId()));
            
            int currentStock = product.getStockQuantity();
            int orderedQuantity = orderItem.getQuantity();
            
            if (currentStock < orderedQuantity) {
                log.error("Insufficient stock for product ID: {}. Required: {}, Available: {}", 
                        product.getId(), orderedQuantity, currentStock);
                throw new RuntimeException("Insufficient stock for product ID: " + product.getId());
            }
            
            product.setStockQuantity(currentStock - orderedQuantity);
            productRepository.save(product);
            
            log.info("Updated inventory for product ID: {}. New stock: {}", 
                    product.getId(), product.getStockQuantity());
        });
    }

    @KafkaListener(topics = "${kafka.topic.order-cancelled}", groupId = "${spring.kafka.consumer.group-id}")
    @Transactional
    public void handleOrderCancelledEvent(OrderEvent orderEvent) {
        log.info("Received order cancelled event for order ID: {}", orderEvent.getOrderId());
        
        // Restore product inventory for each order item
        orderEvent.getOrderItems().forEach(orderItem -> {
            Product product = productRepository.findById(orderItem.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + orderItem.getProductId()));
            
            int currentStock = product.getStockQuantity();
            int orderedQuantity = orderItem.getQuantity();
            
            product.setStockQuantity(currentStock + orderedQuantity);
            productRepository.save(product);
            
            log.info("Restored inventory for product ID: {}. New stock: {}", 
                    product.getId(), product.getStockQuantity());
        });
    }
}