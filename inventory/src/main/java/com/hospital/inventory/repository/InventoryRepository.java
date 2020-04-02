package com.hospital.inventory.repository;

import com.hospital.inventory.entity.Hospital;
import com.hospital.inventory.entity.Inventory;
import com.hospital.inventory.entity.InventoryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, InventoryId> {
  List<Inventory> findByIdHospital(Hospital hospital);
}
