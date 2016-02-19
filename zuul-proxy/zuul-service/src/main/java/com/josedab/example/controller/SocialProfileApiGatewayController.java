package com.josedab.example.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.josedab.example.model.SocialProfile;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/profiles")
public class SocialProfileApiGatewayController {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private Source source;
    
    @HystrixCommand(fallbackMethod = "getProfileNamesFallback")
    @RequestMapping(method=RequestMethod.GET, value="/names/{service")
    public Collection<String> getProfileNamesForService(@RequestParam("service") String service) {
        ParameterizedTypeReference<Resources<SocialProfile>> typeReference = new ParameterizedTypeReference<Resources<SocialProfile>>() {};
        ResponseEntity<Resources<SocialProfile>> profiles = restTemplate.exchange("http://" + service + "/socialProfiles", HttpMethod.GET,null, typeReference);
        return profiles.getBody().getContent()
                                 .stream()
                                 .map(SocialProfile::getName)
                                 .collect(Collectors.toList());
        
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public void writeProfile(@RequestBody SocialProfile socialProfile) {
        Message<String> message = MessageBuilder.withPayload(socialProfile.getName()).build();
        source.output().send(message);
    }
    
    public Collection<String> getProfileNamesFallback() {
        return new ArrayList<String>();
    }
}
