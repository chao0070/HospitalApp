package com.hospital.inventory.repository;

import com.hospital.inventory.entity.Hospital;
import com.hospital.inventory.entity.InventoryManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryManagerRepository extends JpaRepository<InventoryManager, Integer> {
}
