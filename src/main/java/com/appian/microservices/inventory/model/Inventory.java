package com.appian.microservices.inventory.model;

public class Inventory {

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

  public int getQuantity() {
    return quantity;
  }
}
