package com.josedab.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SocialProfile {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public SocialProfile() {}

    public SocialProfile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
