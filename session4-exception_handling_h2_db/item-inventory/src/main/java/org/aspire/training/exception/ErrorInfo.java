package org.aspire.training.exception;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {
	private int errorCode; 
	private int restStatus; 
	private Map<Lang, String> msgs; 
}
