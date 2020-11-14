package org.aspire.training.repository.impl.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepositoryMongo extends MongoRepository<ItemDocument, String>{

}
