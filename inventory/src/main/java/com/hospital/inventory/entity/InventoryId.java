package com.hospital.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryId implements Serializable {
  @ManyToOne
  @JoinColumn(name="hospital_id")
  Hospital hospital;

//  @Column(name="hospital_id")
//  int hospitalId;

  @ManyToOne
  @JoinColumn(name="item_id")
  Item item;
//  @Column(name="item_id")
//  int itemId;
}
