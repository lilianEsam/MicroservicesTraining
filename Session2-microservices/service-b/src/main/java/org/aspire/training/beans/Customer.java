package org.aspire.training.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	public static final Customer EMPTY = new Customer();
	int id; 
	String name; 
	int age;  
	Gender gender; 
}
