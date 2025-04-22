package com.ktpm.customerservice.controller;

import com.ktpm.customerservice.dto.CustomerRequest;
import com.ktpm.customerservice.dto.CustomerResponse;
import com.ktpm.customerservice.service.CustomerService;
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
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;
    private static final String CUSTOMER_SERVICE = "customerService";

    @PostMapping
    @CircuitBreaker(name = CUSTOMER_SERVICE, fallbackMethod = "createCustomerFallback")
    @RateLimiter(name = CUSTOMER_SERVICE)
    @Retry(name = CUSTOMER_SERVICE)
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.createCustomer(customerRequest));
    }

    @GetMapping
    @CircuitBreaker(name = CUSTOMER_SERVICE, fallbackMethod = "getAllCustomersFallback")
    @RateLimiter(name = CUSTOMER_SERVICE)
    @Retry(name = CUSTOMER_SERVICE)
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name = CUSTOMER_SERVICE, fallbackMethod = "getCustomerByIdFallback")
    @RateLimiter(name = CUSTOMER_SERVICE)
    @Retry(name = CUSTOMER_SERVICE)
    @TimeLimiter(name = CUSTOMER_SERVICE)
    public CompletableFuture<ResponseEntity<CustomerResponse>> getCustomerById(@PathVariable Long id) {
        return CompletableFuture.supplyAsync(() -> 
            ResponseEntity.ok(customerService.getCustomerById(id))
        );
    }

    @PutMapping("/{id}")
    @CircuitBreaker(name = CUSTOMER_SERVICE, fallbackMethod = "updateCustomerFallback")
    @RateLimiter(name = CUSTOMER_SERVICE)
    @Retry(name = CUSTOMER_SERVICE)
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customerRequest));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CircuitBreaker(name = CUSTOMER_SERVICE, fallbackMethod = "deleteCustomerFallback")
    @RateLimiter(name = CUSTOMER_SERVICE)
    @Retry(name = CUSTOMER_SERVICE)
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    // Fallback methods
    public ResponseEntity<CustomerResponse> createCustomerFallback(CustomerRequest customerRequest, Exception ex) {
        log.error("Create customer fallback executed: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }

    public ResponseEntity<List<CustomerResponse>> getAllCustomersFallback(Exception ex) {
        log.error("Get all customers fallback executed: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Collections.emptyList());
    }

    public CompletableFuture<ResponseEntity<CustomerResponse>> getCustomerByIdFallback(Long id, Exception ex) {
        log.error("Get customer by id fallback executed for id {}: {}", id, ex.getMessage());
        return CompletableFuture.supplyAsync(() -> 
            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build()
        );
    }

    public ResponseEntity<CustomerResponse> updateCustomerFallback(Long id, CustomerRequest customerRequest, Exception ex) {
        log.error("Update customer fallback executed for id {}: {}", id, ex.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }

    public void deleteCustomerFallback(Long id, Exception ex) {
        log.error("Delete customer fallback executed for id {}: {}", id, ex.getMessage());
        // You could implement alternative logic here if needed
    }
}