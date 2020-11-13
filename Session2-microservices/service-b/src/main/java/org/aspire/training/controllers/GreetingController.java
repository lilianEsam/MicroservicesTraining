package org.aspire.training.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.aspire.training.beans.Customer;
import org.aspire.training.helper.ServiceHelper;
import org.aspire.training.openfeign.UMUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/greeting")
public class GreetingController {

	@Autowired 
	private UMUserInterface umUserInterface; 
	
	
	@GetMapping("/{userId}")
	public String greet(@PathVariable("userId") Integer userId) {
		
		Customer customer = umUserInterface.getUser(userId); 
		
		if(customer.equals(Customer.EMPTY)) return ServiceHelper.GENERIC_MSG; 
		
		String greetingMsg = ServiceHelper.buildGreetingMessage(customer); 
		
		return greetingMsg;  
	}
	
	@GetMapping 
	public String greetAll() {
		
		List<Customer> customers = umUserInterface.getUsers(); 

		if(customers.isEmpty()) return ServiceHelper.GENERIC_MSG; 
		
		String greetingMessage  = customers.stream()
				.map(customer -> ServiceHelper.buildGreetingMessage(customer))
				.collect(Collectors.joining("<br>"));
		
		return greetingMessage; 
	}
}
