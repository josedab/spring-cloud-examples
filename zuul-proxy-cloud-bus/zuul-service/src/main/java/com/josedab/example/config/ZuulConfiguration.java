package com.josedab.example.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ZuulConfiguration {

    @LoadBalanced
    @Bean
    public RestTemplate defaultRestTemplate() {
        return new RestTemplate();
    }
}
