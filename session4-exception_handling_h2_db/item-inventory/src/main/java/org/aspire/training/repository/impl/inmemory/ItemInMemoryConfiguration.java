package org.aspire.training.repository.impl.inmemory;

import org.aspire.training.repository.ItemRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "db.in-memory", name = "enabled", matchIfMissing = true)
public class ItemInMemoryConfiguration {

	@Bean 
	public ItemRepository itemReposiotry() {
		return new ItemInMemoryRepositoryImpl(); 
	}
}
