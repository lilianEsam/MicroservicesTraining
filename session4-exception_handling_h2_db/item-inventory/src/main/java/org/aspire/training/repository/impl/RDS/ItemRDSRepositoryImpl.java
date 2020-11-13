package org.aspire.training.repository.impl.RDS;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.aspire.training.model.Item;
import org.aspire.training.model.ItemDescription;
import org.aspire.training.model.Price;
import org.aspire.training.repository.ItemRepository;

public class ItemRDSRepositoryImpl implements ItemRepository{
	
	private final ItemRepositoryRDS itemRepositoryRDS; 
		
	public ItemRDSRepositoryImpl(ItemRepositoryRDS itemRepositoryRDS) {
		this.itemRepositoryRDS = itemRepositoryRDS;
	}

	@Override
	public void addItem(Item item) {
		itemRepositoryRDS.save(toItemEntityMapper.apply(item)); 
	}

	@Override
	public boolean updateItem(Item item) {
		return loadItem(item.getItemId())
				.map(i -> item)
				.map(toItemEntityMapper)
				.map(itemRepositoryRDS::save)
				.map(e -> true)
				.orElse(false); 
	}

	@Override
	public Optional<Item> loadItem(String itemId) {
		return itemRepositoryRDS.findById(itemId)
							.map(toItemMapper);  
	}

	@Override
	public List<Item> getItems() {
		
		return itemRepositoryRDS.findAll().stream()
			.map(toItemMapper)
			.collect(Collectors.toList()); 		
	}

	@Override
	public Optional<Item> getItem(String itemId) {
		return itemRepositoryRDS.findById(itemId)
				.map(toItemMapper);  
	}
	
	private Function<Item, ItemEntity> toItemEntityMapper = item -> 
				ItemEntity.builder()
						.id(item.getItemId())
						.price(item.getPrice().getValue())
						.shortDesc(item.getItemDescription().getShortDesc())
						.longDesc(item.getItemDescription().getLongDesc())
						.build();
				
	private Function<ItemEntity, Item> toItemMapper = itemEntity -> 
				Item.builder()
					.itemId(itemEntity.getId())
					.price(new Price(itemEntity.getPrice()))
					.itemDescription(new ItemDescription(itemEntity.getShortDesc(), itemEntity.getLongDesc()))
					.build(); 

}
