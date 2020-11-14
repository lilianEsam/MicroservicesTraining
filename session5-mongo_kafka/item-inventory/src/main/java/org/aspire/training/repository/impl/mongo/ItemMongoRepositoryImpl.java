package org.aspire.training.repository.impl.mongo;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.aspire.training.model.Item;
import org.aspire.training.model.ItemDescription;
import org.aspire.training.model.Price;
import org.aspire.training.repository.ItemRepository;

public class ItemMongoRepositoryImpl implements ItemRepository{
	
	private ItemRepositoryMongo itemRepositoryMongo;

	public ItemMongoRepositoryImpl(ItemRepositoryMongo itemRepositoryMongo) {
		this.itemRepositoryMongo = itemRepositoryMongo;
	}

	@Override
	public void addItem(Item item) {
		System.out.println("itemRepositoryMongo: " + itemRepositoryMongo);
		itemRepositoryMongo.save(toItemEntityMapper.apply(item));
	}

	@Override
	public boolean updateItem(Item item) {
		
		return loadItem(item.getItemId())
				.map(old ->item)
				.map(toItemEntityMapper)
				.map(itemRepositoryMongo::save)
				.map(i->true)
				.orElse(false); 
	}

	@Override
	public Optional<Item> loadItem(String itemId) {
		return itemRepositoryMongo.findById(itemId)
				.map(toItemMapper);
	}

	@Override
	public List<Item> getItems() {
		return itemRepositoryMongo.findAll().stream()
				.map(toItemMapper)
				.collect(Collectors.toList()); 
	}

	@Override
	public Optional<Item> getItem(String itemId) {
		return itemRepositoryMongo
				.findById(itemId)
				.map(toItemMapper); 
	}

	private Function<Item, ItemDocument> toItemEntityMapper = item -> 
	ItemDocument.builder()
				.id(item.getItemId())
				.price(item.getPrice().getValue())
				.shortDesc(item.getItemDescription().getShortDesc())
				.longDesc(item.getItemDescription().getLongDesc())
				.build();
	
	private Function<ItemDocument, Item> toItemMapper = itemEntity -> 
		Item.builder()
			.itemId(itemEntity.getId())
			.price(new Price(itemEntity.getPrice()))
			.itemDescription(new ItemDescription(itemEntity.getShortDesc(), itemEntity.getLongDesc()))
			.build(); 

	
}
