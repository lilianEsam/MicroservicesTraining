package org.aspire.training.service;

import java.util.List;
import java.util.Optional;

import org.aspire.training.model.Item;
import org.aspire.training.model.Price;
import org.aspire.training.repository.ItemRepository;
import org.springframework.stereotype.Service;

//business 
//this is what the web can do. it cannot access the 
//database implementation directly 
@Service
public class ItemService {

	private final ItemRepository itemRepository; 
	
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public void addItem(Item item) {
		itemRepository.addItem(item); 
	}
	
	public boolean updateItem(Item item) {
		return itemRepository.updateItem(item);
	}
	
	public void updatePrice(String itemId, int newPrice) {
		itemRepository.loadItem(itemId)
				.map(item -> item.toBuilder()
						.price(new Price(newPrice))
						.build())
				.ifPresent((item) -> itemRepository.updateItem(item));;
	}
	
	public void applyDiscount(String itemId, int discount) {
		itemRepository.loadItem(itemId)
			.map(item -> item.toBuilder()
					.price(new Price(item.getPrice().getValue() * discount / 100))
					.build())
			.ifPresent((item) -> itemRepository.updateItem(item));;
	}

	public List<Item> getItems() {

		return itemRepository.getItems();
	}

	public Optional<Item> getItem(String itemId) {
		return itemRepository.getItem(itemId);
	}
}
