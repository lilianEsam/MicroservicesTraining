package org.aspire.restsample.rest;

import org.aspire.restsample.components.GreetingMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingRestAPI {
	
	GreetingMessage greetingMessage; 
	public GreetingRestAPI(GreetingMessage greetingMessage){
		this.greetingMessage = greetingMessage; 
	}
	
	@GetMapping("/{name}")
	public String hello(@PathVariable("name") String clientName, 
			@RequestParam("age") String age) {
		
		return greetingMessage.sayHello() + clientName + ": " + age; 
	}
}
