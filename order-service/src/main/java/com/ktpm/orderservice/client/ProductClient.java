package com.ktpm.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "product-service", path = "/api/products", fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {
    @GetMapping("/{id}")
    ProductResponse getProductById(@PathVariable("id") Long id);
    
    @Component
    class ProductClientFallback implements ProductClient {
        @Override
        public ProductResponse getProductById(Long id) {
            // Return a default product when the service is unavailable
            return ProductResponse.builder()
                    .id(id)
                    .name("Fallback Product")
                    .description("Product Service is currently unavailable")
                    .price(BigDecimal.ZERO)
                    .stockQuantity(0)
                    .build();
        }
    }
}