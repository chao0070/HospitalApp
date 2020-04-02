package com.hospital.inventory.repository;

import com.hospital.inventory.entity.Hospital;
import com.hospital.inventory.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
