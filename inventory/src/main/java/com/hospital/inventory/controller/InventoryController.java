package com.hospital.inventory.controller;

import com.hospital.inventory.entity.Hospital;
import com.hospital.inventory.entity.InventoryManager;
import com.hospital.inventory.repository.HospitalRepository;
import com.hospital.inventory.repository.InventoryManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class InventoryController {

  @Autowired
  InventoryManagerRepository inventoryManagerRepository;

  @GetMapping("/inventorycreate")
  public String inventorycreate(){
    Hospital h = new Hospital();
    h.setId(1);
    InventoryManager im = new InventoryManager("Manager2", "1212", h);
    inventoryManagerRepository.save(im);
    return "InventoryManager is created";
  }

  @GetMapping("/im")
  public List<InventoryManager> inventoryManager() {
    return inventoryManagerRepository.findAll();
  }

  @GetMapping("/im/{id}")
  public InventoryManager inventoryManager(@PathVariable String id) {
    int searchId = Integer.parseInt(id);
    Optional<InventoryManager> inventoryManager = inventoryManagerRepository.findById(searchId);
    if (inventoryManager.isPresent()) {
      return inventoryManager.get();
    }
    return null;
  }
}
