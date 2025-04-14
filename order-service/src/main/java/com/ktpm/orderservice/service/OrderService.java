package com.ktpm.orderservice.service;

import com.ktpm.orderservice.client.ProductClient;
import com.ktpm.orderservice.dto.OrderItemRequest;
import com.ktpm.orderservice.dto.OrderItemResponse;
import com.ktpm.orderservice.dto.OrderRequest;
import com.ktpm.orderservice.dto.OrderResponse;
import com.ktpm.orderservice.event.OrderEventPublisher;
import com.ktpm.orderservice.model.Order;
import com.ktpm.orderservice.model.OrderItem;
import com.ktpm.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final OrderEventPublisher eventPublisher;

    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .customerId(orderRequest.getCustomerId())
                .orderDate(LocalDateTime.now())
                .orderStatus("PENDING")
                .build();

        List<OrderItem> orderItems = orderRequest.getOrderItems().stream()
                .map(orderItemRequest -> {
                    // Get product price from product service
                    var productResponse = productClient.getProductById(orderItemRequest.getProductId());

                    return OrderItem.builder()
                            .productId(orderItemRequest.getProductId())
                            .quantity(orderItemRequest.getQuantity())
                            .price(productResponse.getPrice())  // Assuming ProductResponse has a price() accessor method instead
                            .order(order)
                            .build();
                }).collect(Collectors.toList());

        order.setOrderItems(orderItems);
        
        // Calculate total amount
        BigDecimal totalAmount = orderItems.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        order.setTotalAmount(totalAmount);
        
        Order savedOrder = orderRepository.save(order);
        log.info("Order created with ID: {}", savedOrder.getId());
        
        // Publish order created event
        eventPublisher.publishOrderCreatedEvent(savedOrder);
        
        return mapToOrderResponse(savedOrder);
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(this::mapToOrderResponse).collect(Collectors.toList());
    }

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return mapToOrderResponse(order);
    }

    public List<OrderResponse> getOrdersByCustomerId(Long customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        return orders.stream().map(this::mapToOrderResponse).collect(Collectors.toList());
    }

    @Transactional
    public void cancelOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        
        order.setOrderStatus("CANCELLED");
        Order savedOrder = orderRepository.save(order);
        log.info("Order with ID: {} has been cancelled", id);
        
        // Publish order cancelled event
        eventPublisher.publishOrderCancelledEvent(savedOrder);
    }

    private OrderResponse mapToOrderResponse(Order order) {
        List<OrderItemResponse> orderItemResponses = order.getOrderItems().stream()
                .map(orderItem -> OrderItemResponse.builder()
                        .id(orderItem.getId())
                        .productId(orderItem.getProductId())
                        .quantity(orderItem.getQuantity())
                        .price(orderItem.getPrice())
                        .build())
                .collect(Collectors.toList());
        
        return OrderResponse.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .orderDate(order.getOrderDate())
                .orderStatus(order.getOrderStatus())
                .totalAmount(order.getTotalAmount())
                .orderItems(orderItemResponses)
                .build();
    }
}