package org.aspire.training.repository.impl.inmemory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.aspire.training.model.Item;
import org.aspire.training.repository.ItemRepository;

public class ItemInMemoryRepositoryImpl implements ItemRepository{

	private Map<String, Item> db = new HashMap<>(); 
	
	@Override
	public void addItem(Item item) {

		db.put(item.getItemId(), item); 
	}

	@Override
	public boolean updateItem(Item item) {
		db.computeIfPresent(item.getItemId(), 
				(k, v) -> db.put(k, item)); 
		
		return true; 
	}

	@Override
	public Optional<Item> loadItem(String itemId) {
		Item item = db.get(itemId); 
		
		return Optional.ofNullable(item);
	}

	@Override
	public List<Item> getItems() {
	
		return db.values().stream().collect(Collectors.toList()); 
	}

	@Override
	public Optional<Item> getItem(String itemId) {

		return Optional.ofNullable(db.get(itemId));
	}

}
