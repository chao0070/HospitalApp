package com.hospital.inventory.controller;

import com.hospital.inventory.entity.Hospital;
import com.hospital.inventory.entity.Inventory;
import com.hospital.inventory.entity.InventoryId;
import com.hospital.inventory.entity.InventoryManager;
import com.hospital.inventory.entity.Item;
import com.hospital.inventory.repository.HospitalRepository;
import com.hospital.inventory.repository.InventoryManagerRepository;
import com.hospital.inventory.repository.InventoryRepository;
import com.hospital.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class InventoryController {
  @Autowired
  InventoryRepository inventoryRepository;

  @Autowired
  HospitalRepository hospitalRepository;

  @Autowired
  InventoryManagerRepository inventoryManagerRepository;

  @Autowired
  ItemRepository itemRepository;

  @GetMapping("/createinventory")
  public String createInventory(){
    Hospital hospital = hospitalRepository.save(new Hospital("H4", "Shillong", System.currentTimeMillis()));
    Item im = new Item("Toothpaste");
    itemRepository.save(im);
    InventoryId id = new InventoryId(hospital, im);
    inventoryRepository.save(new Inventory(id, 10));

    hospital = hospitalRepository.save(new Hospital("H5", "Bombay", System.currentTimeMillis()));
    im = new Item("Vitamins");
    itemRepository.save(im);
    id = new InventoryId(hospital, im);
    inventoryRepository.save(new Inventory(id, 20));

    return "inventory updated";
  }

  @GetMapping("/inventory/all")
  public List<Inventory> inventories() {
    return inventoryRepository.findAll();
  }

  @GetMapping("/inventory")
  public Inventory inventory(@RequestParam(value = "hospital") Integer hospitalId, @RequestParam(value = "item") Integer itemId) {
    Optional<Inventory> inventory = inventoryRepository.findById(new InventoryId(Hospital.builder().id(hospitalId).build(), Item.builder().id(itemId).build()));
    if (inventory.isPresent()) {
      return inventory.get();
    }
    return null;
  }

  @GetMapping("/inventory/hospital/{id}")
  public List<Inventory> inventory(@PathVariable Integer id) {
    List<Inventory> in =
      inventoryRepository.findByIdHospital(Hospital.builder().id(id).build());
    for (Inventory inventory : in) {
      System.out.println(inventory.toString());
    }
    System.out.println("Thissssssssssssss");
    return in;
  }
}
