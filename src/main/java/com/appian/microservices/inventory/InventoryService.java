package com.appian.microservices.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appian.microservices.inventory.model.Delete;
import com.appian.microservices.inventory.model.Update;
import com.appian.microservices.inventory.repository.Inventory;
import com.appian.microservices.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

  // docker run --name mongodb -p 27017:27017 mongo
  // docker start mongodb
  // curl -H "Content-Type: application/json" -X POST -d '{"id":"10","quantity":"10", "type":"increase"}' -X PUT localhost:8080/products
  // show dbs
  // show collections
  // db.test_table.find( {} )
  // db.test_table.find( { _id: "2" } )

  @Autowired
  private InventoryRepository repository;

  public List<Inventory> list() {
    return repository.findAll();
  }

  Inventory get(String sku) {
    return repository.findOne(sku);
  }

  Inventory update(Update update) {
    Inventory inventory = repository.findOne(update.getSku());
    if (inventory == null) {
      // new product
      inventory = new Inventory();
      inventory.setSku(update.getSku());
    }

    int qty;
    switch (update.getType()) {
      case DECREASE:
        qty = inventory.getQuantity() - update.getQuantity();
        if (qty < 0) {
          throw new RuntimeException("invalid quantity: " + update.getQuantity());
        }
        break;
      case INCREASE:
        qty = inventory.getQuantity() + update.getQuantity();
        break;
      default:
        throw new RuntimeException("Unsupported update type: " + update.getType());
    }

    inventory.setQuantity(qty);
    return repository.save(inventory);
  }

  Delete delete(Delete delete) {
    repository.delete(delete.getSku());
    return delete;
  }
}
