package org.aspire.introApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SimpleStartupHandler implements CommandLineRunner {

	@Autowired 
	Environment env; 
	
	@Value("${greeting: 'hello..'}")
	String greeting; 
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("From env obj: " + env.getProperty("greeting"));	
		System.out.println("From @value: " + greeting);
		System.out.println("Command Line Runner Called");

	}
	
}
