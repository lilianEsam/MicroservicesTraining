package org.aspire.training.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//simpler represenation of the Item model depending on the client
//need 
//javax validations go here 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
public class ItemDTO {

	private String id; 

	@Min(0)
	private int price; 
	
	@NotEmpty
	private String desc; 
}
