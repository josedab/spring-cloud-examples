package com.josedab.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.josedab.example.SvcAServiceApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SvcAServiceApplication.class)
@WebAppConfiguration
public class SocialMediaServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
