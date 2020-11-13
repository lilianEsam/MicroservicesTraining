package org.aspire.httpverbs;

import org.aspire.httpverbs.beans.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HttpVerbsApp {

	public static void main(String[] args) {
		SpringApplication.run(HttpVerbsApp.class, args);
	}
	
	@Bean 
	public CommandLineRunner test() {
		return (args) -> {
			User lilian = new User("1", "Lilian", 30); 
			System.out.println("Hello: " + lilian.getName());
		};  
	}
}
