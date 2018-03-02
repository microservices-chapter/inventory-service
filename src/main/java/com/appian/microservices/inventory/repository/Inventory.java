package com.appian.microservices.inventory.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.appian.microservices.inventory.util.Utils;

@Document(collection="inventory")
public class Inventory {

  @Id
  private String sku;
  private int quantity;
  private long timestamp;

  public Inventory() {
    this.timestamp = Utils.localToUTC();
  }

  public Inventory(String sku, int quantity) {
    this.sku = sku;
    this.quantity = quantity;
    this.timestamp = Utils.localToUTC();
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public long getTimestamp() {
    return timestamp;
  }
}
