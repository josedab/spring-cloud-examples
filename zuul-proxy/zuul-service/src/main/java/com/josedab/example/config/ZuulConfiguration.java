package com.josedab.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ZuulConfiguration {

    @Bean
    public RestTemplate defaultRestTemplate() {
        return new RestTemplate();
    }
}
