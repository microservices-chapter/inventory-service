package com.appian.microservices.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appian.microservices.inventory.model.DeleteRequest;
import com.appian.microservices.inventory.model.Inventory;
import com.appian.microservices.inventory.model.UpdateRequest;
import com.appian.microservices.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

  // docker run --name mongodb -p 27017:27017 mongo
  // show dbs
  // show collections
  // db.test_table.find( {} )
  // db.test_table.find( { _id: "2" } )

  @Autowired
  private InventoryRepository repository;

  public List<Inventory> list() {
    return repository.findAll();
  }

  Inventory get(String productId) {
    return repository.findOne(productId);
  }

  Inventory update(UpdateRequest updateRequest) {
    Inventory inventory = repository.findOne(updateRequest.getId());
    if (inventory == null) {
      // new product
      inventory = new Inventory();
      inventory.setId(updateRequest.getId());
    }

    int qty;
    switch (updateRequest.getType()) {
      case REDUCE:
        qty = inventory.getQuantity() - updateRequest.getQuantity();
        if (qty < 0) {
          throw new RuntimeException("invalid quantity");
        }
        break;
      case INCREASE:
        qty = inventory.getQuantity() + updateRequest.getQuantity();
        break;
      default:
        throw new RuntimeException("Unsupported updateRequest type: " + updateRequest.getType());
    }

    inventory.setQuantity(qty);
    return repository.save(inventory);
  }

  DeleteRequest delete(DeleteRequest deleteRequest) {
    repository.delete(deleteRequest.getId());
    return deleteRequest;
  }
}
