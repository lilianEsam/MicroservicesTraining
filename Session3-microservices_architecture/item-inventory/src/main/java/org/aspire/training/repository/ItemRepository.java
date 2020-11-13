package org.aspire.training.repository;

import java.util.List;
import java.util.Optional;

import org.aspire.training.model.Item;

public interface ItemRepository {

	void addItem(Item item);

	boolean updateItem(Item item);

	Optional<Item> loadItem(String itemId);

	List<Item> getItems();

	
}
