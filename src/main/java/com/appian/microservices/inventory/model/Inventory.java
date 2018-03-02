package com.appian.microservices.inventory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="inventory")
public class Inventory {

  // TODO: add UTC timestamp

  @Id
  private String id;
  private int quantity;

  public Inventory() {
  }

  public Inventory(String id, int quantity) {
    this.id = id;
    this.quantity = quantity;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
