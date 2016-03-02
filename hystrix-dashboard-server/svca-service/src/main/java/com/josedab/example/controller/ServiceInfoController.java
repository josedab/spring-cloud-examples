package com.josedab.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ServiceInfoController {
    
    @Value("${name}")
    private String serviceName;
    
    @RequestMapping("/info/name")
    public String getInfo(){
        return this.serviceName;
    }
    
}
