package org.aspire.training.repository.impl.RDS;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ItemEntity {
	@Id	
	private String id; 
	
	private int price; 
	
	private String shortDesc; 
	
	private String longDesc; 
	
}
