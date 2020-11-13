package org.aspire.restsample.configuration;

import org.aspire.restsample.components.GreetingMessage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("dev")
@ConditionalOnProperty(prefix = "org.aspire", name = "enabled",
matchIfMissing = true)
public class DevConfiguration {

	@Bean 
	public GreetingMessage getGreetingMessage() {
		return new GreetingMessage(); 
	}
}
