package org.aspire.training.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//root entity 

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
public class Item {
	
	private String itemId;
	private Price price; 
	private ItemDescription itemDescription; 
	
	// another representation - aggregate
	private Manafaturer manafaturer;  
}
