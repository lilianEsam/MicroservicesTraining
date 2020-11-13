package org.aspire.introApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntroApp {
	
	
	@Bean 
	public CommandLineRunner testInjection(SampleComponent sampleComponenet) {
		return (args)->{
			System.out.println(sampleComponenet.getGreetingMessage());	
		}; 
	}
	
	public static void main(String[] args) {

		SpringApplication.run(IntroApp.class, args);
	}

}
