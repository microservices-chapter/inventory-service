package com.appian.microservices.inventory.model;

public class UpdateRequest {

  private String id;
  private int quantity;
  private Type type;

  public UpdateRequest() {
  }

  public UpdateRequest(String id, int quantity, Type type) {
    this.id = id;
    this.quantity = quantity;
    this.type = type;
  }

  public String getId() {
    return id;
  }

  public int getQuantity() {
    return quantity;
  }

  public Type getType() {
    return type;
  }
}
