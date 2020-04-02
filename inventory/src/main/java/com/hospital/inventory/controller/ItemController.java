package com.hospital.inventory.controller;

import com.hospital.inventory.entity.Hospital;
import com.hospital.inventory.entity.InventoryManager;
import com.hospital.inventory.entity.Item;
import com.hospital.inventory.repository.InventoryManagerRepository;
import com.hospital.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {
  @Autowired
  ItemRepository itemRepository;

  @GetMapping("/createitems")
  public String createItem(){
    Item im = new Item("Face Mask");
    itemRepository.save(im);
    return "Item is created";
  }

  @GetMapping("/item")
  public List<Item> items() {
    return itemRepository.findAll();
  }

  @GetMapping("/item/{id}")
  public Item item(@PathVariable String id) {
    int searchId = Integer.parseInt(id);
    Optional<Item> item = itemRepository.findById(searchId);
    if (item.isPresent()) {
      return item.get();
    }
    return null;
  }
}
