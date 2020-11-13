package org.aspire.training.rest;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.aspire.training.dto.ItemDTO;
import org.aspire.training.model.Item;
import org.aspire.training.model.ItemDescription;
import org.aspire.training.model.Price;
import org.aspire.training.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

	private final ItemService itemService; 
	
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@PostMapping
	public String addingItem(@RequestBody @Valid ItemDTO itemDTO) {

		itemDTO.setId(UUID.randomUUID().toString());
		
		Item item = toItemModelMapper.apply(itemDTO); 

		itemService.addItem(item);
		
		return item.getItemId(); 
	}
	
	@GetMapping 
	public List<ItemDTO> getAllItems(){
		
		List<Item> items = itemService.getItems();
	
		List<ItemDTO> itemsDTO = items.stream()
			.map(toItemDTOMapper)
			.collect(Collectors.toList()); 
		
		return itemsDTO; 
	}
	
	private Function<ItemDTO, Item> toItemModelMapper = dto -> {
		return Item.builder()
				.itemId(dto.getId())
				.price(new Price(dto.getPrice()))
				.itemDescription(new ItemDescription(dto.getDesc(), ""))
				.build(); 			
	}; 
	
	private Function<Item, ItemDTO> toItemDTOMapper = item -> {
		return ItemDTO.builder()
				.price(item.getPrice().getValue())
				.desc(item.getItemDescription().getLongDesc())
				.id(item.getItemId())
				.build(); 			
	}; 
}
