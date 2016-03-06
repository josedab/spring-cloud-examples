package com.josedab.example.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.josedab.example.model.SocialProfile;
import com.josedab.example.repository.SocialProfileRepository;

@MessageEndpoint
public class SocialProfileProcessor {

    @Autowired
    private SocialProfileRepository socialProfileRepository;

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void acceptNewProfiles(String profileName) {
        socialProfileRepository.save(new SocialProfile(profileName));
    }

}
