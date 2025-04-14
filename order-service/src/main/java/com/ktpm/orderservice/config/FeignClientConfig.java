package com.ktpm.orderservice.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.codec.ErrorDecoder;
import feign.Retryer;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableFeignClients(basePackages = "com.ktpm.orderservice.client")
public class FeignClientConfig {

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 3);
    }
    
    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
    
    private static class CustomErrorDecoder implements ErrorDecoder {
        private final ErrorDecoder defaultErrorDecoder = new Default();
        
        @Override
        public Exception decode(String methodKey, feign.Response response) {
            // You can add custom error handling logic here
            return defaultErrorDecoder.decode(methodKey, response);
        }
    }
}