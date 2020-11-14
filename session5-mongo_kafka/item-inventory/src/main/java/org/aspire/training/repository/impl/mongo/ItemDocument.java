package org.aspire.training.repository.impl.mongo;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class ItemDocument {

	@Id	
	private String id; 
	
	private int price; 
	
	private String shortDesc; 
	
	private String longDesc; 

}
