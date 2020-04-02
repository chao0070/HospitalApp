package com.hospital.inventory.controller;

import com.hospital.inventory.entity.Hospital;
import com.hospital.inventory.entity.InventoryManager;
import com.hospital.inventory.repository.HospitalRepository;
import com.hospital.inventory.repository.InventoryManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HospitalController {
  @Autowired
  HospitalRepository hospitalRepository;

  @Autowired
  InventoryManagerRepository inventoryManagerRepository;

  @GetMapping("/bulkcreate")
  public String bulkcreate(){
    Hospital hospital = hospitalRepository.save(new Hospital("H1", "Delhi", System.currentTimeMillis()));
    InventoryManager im = new InventoryManager("Manager1", "1212", hospital);
    inventoryManagerRepository.save(im);
    return "Customers are created";
  }

  @GetMapping("/hospital")
  public List<Hospital> hospitals() {
    return hospitalRepository.findAll();
  }

  @GetMapping("/hospital/{id}")
  public Hospital hospital(@PathVariable String id) {
    int searchId = Integer.parseInt(id);
    Optional<Hospital> hospital = hospitalRepository.findById(searchId);
    if (hospital.isPresent()) {
      return hospital.get();
    }
    return null;
  }



}
