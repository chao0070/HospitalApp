package com.hospital.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "inventory_manager")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryManager implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  @Column(name = "userid")
  String userid;

  @Column(name = "password")
  String password;

  @ManyToOne
  @JoinColumn(name="hospital_id", referencedColumnName="id", nullable=false, updatable=false)
  Hospital hospital;

  public InventoryManager(String userid, String password, Hospital hospital) {
    this.userid = userid;
    this.password = password;
    this.hospital = hospital;
  }
}
