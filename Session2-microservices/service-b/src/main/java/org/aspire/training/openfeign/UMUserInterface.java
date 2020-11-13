package org.aspire.training.openfeign;

import java.util.List;

import org.aspire.training.beans.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="service-a", fallback = UMServiceAFailImpl.class)
public interface UMUserInterface {
	
	@GetMapping("/users/{userId}")
	public Customer getUser(@PathVariable("userId") Integer userId); 
	
	
	@GetMapping("/users")
	public List<Customer> getUsers(); 
}
