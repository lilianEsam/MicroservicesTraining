package org.aspire.training.repository.impl.mongo;

import org.aspire.training.repository.ItemRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "db.mongo", name = "enabled", matchIfMissing = false)
public class ItemMongoConfiguration {

	@Bean 
	public ItemRepository itemReposiotry(ItemRepositoryMongo itemRepositoryMongo) {
		return new ItemMongoRepositoryImpl(itemRepositoryMongo); 
	}
}
