package com.josedab.example.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.josedab.example.model.SocialProfile;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/profiles")
public class SocialProfileApiGatewayController {
    
    private static final String SERVICE_A = "svca-service";
    private static final String SERVICE_B = "svcb-service";

    @Autowired
    private RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "getProfileNamesFallback")
    @RequestMapping(method=RequestMethod.GET, value="/names/{service}")
    public Collection<String> getProfileNamesForService(@PathVariable("service") String service) {
        ParameterizedTypeReference<Resources<SocialProfile>> typeReference = new ParameterizedTypeReference<Resources<SocialProfile>>() {};
        ResponseEntity<Resources<SocialProfile>> profiles = 
                restTemplate.exchange(
                        "http://" + service + "/socialProfiles", 
                        HttpMethod.GET, 
                        null, 
                        typeReference);
        
        return profiles.getBody().getContent()
                                 .stream()
                                 .map(SocialProfile::getName)
                                 .collect(Collectors.toList());
        
    }
    
    @HystrixCommand(fallbackMethod = "getProfileNamesFallback")
    @RequestMapping(method=RequestMethod.GET, value="/names")
    public Collection<String> getProfileNamesForService() {
        Collection<String> results = getProfileNamesForService(SERVICE_A);
        Collection<String> svcbResults = getProfileNamesForService(SERVICE_B);
        results.addAll(svcbResults);
        return results;
    }

    private Collection<String> getProfileNamesFallback() {
        return new ArrayList<String>();
    }
    
    private Collection<String> getProfileNamesFallback(String service) {
        return getProfileNamesFallback();
    }
    
}
