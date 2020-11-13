package org.aspire.training.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="com.aspire.training")
@Configuration
public class AllErrorMessages {

	private Map<String, ErrorInfo> errorMsgs = new HashMap<>(); 
	
	public Optional<ErrorInfo> byClass(AbstractException e) {
		return Optional.ofNullable(
					errorMsgs.get(e.getClass().getSimpleName())
				);
	}
}
