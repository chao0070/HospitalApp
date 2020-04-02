package com.hospital.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "hospital")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital  implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  @Column(name = "name")
  String name;

  @Column(name = "location")
  String location;

  @Column(name = "timestamp")
  long timestamp;

  public Hospital(String name, String location, long timestamp) {
    this.name = name;
    this.location = location;
    this.timestamp = timestamp;
  }
}
