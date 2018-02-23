package com.appian.microservices.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.appian.microservices.inventory.model.Inventory;

@Service
public class InventoryService {

  public List<Inventory> getAll() {
    List<Inventory> l = new ArrayList<>();
    l.add(new Inventory(UUID.randomUUID().toString(), 3));
    l.add(new Inventory(UUID.randomUUID().toString(), 2));
    return l;
  }

  public Inventory get(String productId) {
    return (new Inventory(productId, 1));
  }

  public List<Inventory> update(List<Inventory> items) {
    return items;
  }
}
