package org.aspire.restsample.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component 
public class GreetingMessage {

	@Value("${org.aspire.greeting}")
	private String message; 
	
	public String sayHello() {
		return message; 
	}
}
