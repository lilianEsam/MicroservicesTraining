package org.aspire.restsample.configuration;

import org.aspire.restsample.components.GreetingMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("qa")
public class QaConfiguration {

	@Bean 
	public GreetingMessage getGreetingMessage() {
		return new GreetingMessage(); 
	}
}
