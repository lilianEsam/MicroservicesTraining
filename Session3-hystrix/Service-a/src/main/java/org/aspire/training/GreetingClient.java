package org.aspire.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController 
@RequestMapping("/greeting-client")

public class GreetingClient {
	
	@Autowired 
	ServiceBClient serviceBClient; 
	
	@GetMapping("{name}")
	@HystrixCommand(fallbackMethod = "defaultGreeting")
	public String greeting(@PathVariable("name") String name) {

		return serviceBClient.greeting(name); 
	}

	
	public String defaultGreeting(String name) { 
		return "Default call " + name; 
	}
}
