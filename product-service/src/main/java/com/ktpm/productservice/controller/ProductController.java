package com.ktpm.productservice.controller;

import com.ktpm.productservice.dto.ProductRequest;
import com.ktpm.productservice.dto.ProductResponse;
import com.ktpm.productservice.service.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;
    private static final String PRODUCT_SERVICE = "productService";

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = PRODUCT_SERVICE, fallbackMethod = "createProductFallback")
    @RateLimiter(name = PRODUCT_SERVICE)
    @Retry(name = PRODUCT_SERVICE)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @CircuitBreaker(name = PRODUCT_SERVICE, fallbackMethod = "getAllProductsFallback")
    @RateLimiter(name = PRODUCT_SERVICE)
    @Retry(name = PRODUCT_SERVICE)
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name = PRODUCT_SERVICE, fallbackMethod = "getProductByIdFallback")
    @RateLimiter(name = PRODUCT_SERVICE)
    @Retry(name = PRODUCT_SERVICE)
    @TimeLimiter(name = PRODUCT_SERVICE)
    public CompletableFuture<ResponseEntity<ProductResponse>> getProductById(@PathVariable Long id) {
        return CompletableFuture.supplyAsync(() -> 
            ResponseEntity.ok(productService.getProductById(id))
        );
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CircuitBreaker(name = PRODUCT_SERVICE, fallbackMethod = "updateProductFallback")
    @RateLimiter(name = PRODUCT_SERVICE)
    @Retry(name = PRODUCT_SERVICE)
    public void updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        productService.updateProduct(id, productRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CircuitBreaker(name = PRODUCT_SERVICE, fallbackMethod = "deleteProductFallback")
    @RateLimiter(name = PRODUCT_SERVICE)
    @Retry(name = PRODUCT_SERVICE)
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // Fallback methods
    public void createProductFallback(ProductRequest productRequest, Exception ex) {
        log.error("Create product fallback executed: {}", ex.getMessage());
        // You could implement alternative logic here if needed
    }

    public ResponseEntity<List<ProductResponse>> getAllProductsFallback(Exception ex) {
        log.error("Get all products fallback executed: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Collections.emptyList());
    }

    public CompletableFuture<ResponseEntity<ProductResponse>> getProductByIdFallback(Long id, Exception ex) {
        log.error("Get product by id fallback executed for id {}: {}", id, ex.getMessage());
        return CompletableFuture.supplyAsync(() -> 
            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null)
        );
    }

    public void updateProductFallback(Long id, ProductRequest productRequest, Exception ex) {
        log.error("Update product fallback executed for id {}: {}", id, ex.getMessage());
        // You could implement alternative logic here if needed
    }

    public void deleteProductFallback(Long id, Exception ex) {
        log.error("Delete product fallback executed for id {}: {}", id, ex.getMessage());
        // You could implement alternative logic here if needed
    }
}