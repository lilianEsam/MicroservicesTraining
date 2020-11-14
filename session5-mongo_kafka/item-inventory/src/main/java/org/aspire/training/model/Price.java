package org.aspire.training.model;

import lombok.Value;

//final, cannot exist without its root entity 

@Value
public class Price {
	private final int value; 
	
	public Price withQty(int qty) {
		return new Price(value*qty); 
	}
	
	public Price withDsicount(int discount) {
		return new Price(value * discount / 100);
	}
}
