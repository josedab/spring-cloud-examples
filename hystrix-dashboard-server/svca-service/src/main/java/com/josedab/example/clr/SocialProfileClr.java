package com.josedab.example.clr;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.josedab.example.model.SocialProfile;
import com.josedab.example.repository.SocialProfileRepository;

@Component
public class SocialProfileClr implements CommandLineRunner {
    
    @Autowired
    private SocialProfileRepository socialProfileRepository;

    @Override
    public void run(String... arg0) throws Exception {
        Stream.<String>of("Katy Perry",
                          "Justin Bieber",
                          "Taylor Swift",
                          "Barack Obama",
                          "Youtube",
                          "Rihanna",
                          "Lady Gaga")
              .forEach(name -> socialProfileRepository.save(new SocialProfile(name)));
        
    }

}
