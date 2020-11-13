package org.aspire.introApp;

import org.springframework.stereotype.Component;

@Component
public class SampleComponent {

	public String getGreetingMessage() {
		return "Hello from getGreetingMessage()!"; 
	}
}
