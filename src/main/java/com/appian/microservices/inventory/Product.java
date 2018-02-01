package com.appian.microservices.inventory;

public class Product {
   private String uuid;

  public Product(String uuid) {
    this.uuid = uuid;
  }

  public String getUuid() {
    return uuid;
  }
}
