package org.aspire.training.helper;

import java.util.function.Predicate;

import org.aspire.training.beans.Customer;
import org.aspire.training.beans.Gender;

public class ServiceHelper {
	
	public final static String GENERIC_MSG = "Hello!"; 

	public static String buildGreetingMessage(Customer customer) {
		Predicate<Customer> isMale = (c) -> c.getGender().equals(Gender.MALE); 
		
		String greetingMsg = new StringBuilder() 
				.append("Hello ")
				.append(isMale.test(customer) ? "Mr. " : "Ms. ")
				.append(customer.getName())
				.toString(); 
		
		return greetingMsg;
	}
}
