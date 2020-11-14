package org.aspire.training.exception;

import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	private final AllErrorMessages allErrorMessages; 
	
	public RestExceptionHandler(AllErrorMessages allErrorMessages) {
		this.allErrorMessages = allErrorMessages;
	}

	@ExceptionHandler(AbstractException.class)
	public ResponseEntity<Object> handleTrainingException(AbstractException e){
		ErrorInfo eInfo = allErrorMessages.byClass(e)
				.orElseGet(() -> generalErrorInfo(e)); 
		
		return new ResponseEntity<>(eInfo, new HttpHeaders(), 
				HttpStatus.resolve(eInfo.getRestStatus())) ; 
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleGeneralException(RuntimeException e){
		

		e.printStackTrace();
		
		ErrorInfo eInfo = generalErrorInfo(e); 
		
		return new ResponseEntity<>(eInfo, new HttpHeaders(), 
				HttpStatus.resolve(eInfo.getRestStatus())) ; 
	}
	
	@SuppressWarnings("unchecked")
	public ErrorInfo generalErrorInfo(RuntimeException e){
		return ErrorInfo
				.builder()
				.errorCode(0)
				.restStatus(HttpStatus.BAD_REQUEST.value())
				.msgs(new HashMap(){ {
					put(Lang.AR, "arabic msg: " + e.getMessage()); 
					put(Lang.EN, "english msg: " + e.getMessage()); 
				}})
				.build(); 
	}
}
