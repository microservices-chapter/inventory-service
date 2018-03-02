package com.appian.microservices.inventory.model;

public class DeleteRequest {

  private String id;

  public DeleteRequest() {
  }

  public DeleteRequest(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
