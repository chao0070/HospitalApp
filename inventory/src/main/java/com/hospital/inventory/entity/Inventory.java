package com.hospital.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="inventory")
public class Inventory implements Serializable {
  @EmbeddedId
  InventoryId id;

  @Column(name="quantity")
  int quantity;

  public Inventory(InventoryId id) {
    this.id = id;
  }

//  @ManyToOne
//  @JoinColumn(name="hospital_id")
//  public Hospital getHospital() {
//    return id.getHospital();
//  }
//
//  @ManyToOne
//  @JoinColumn(name="item_id")
//  public Item getItem() {
//    return id.getItem();
//  }
}
