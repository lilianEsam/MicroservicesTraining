package org.aspire.training.repository.impl.RDS;

import org.aspire.training.repository.ItemRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "db.RDS", name = "enabled", matchIfMissing = false)
public class ItemRDSConfiguration {

	@Bean 
	public ItemRepository itemReposiotry(ItemRepositoryRDS itemRepositoryRDS) {
		return new ItemRDSRepositoryImpl(itemRepositoryRDS); 
	}
}
