package com.appian.microservices.inventory;

import static com.appian.microservices.inventory.model.Status.INACTIVE;
import static java.util.Comparator.comparingLong;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appian.microservices.inventory.model.Delete;
import com.appian.microservices.inventory.model.Update;
import com.appian.microservices.inventory.repository.Inventory;
import com.appian.microservices.inventory.repository.InventoryRepository;
import com.google.common.collect.Lists;

@Service
public class InventoryService {

  // docker run --name mongodb -p 27017:27017 mongo
  // docker start mongodb
  // curl -H "Content-Type: application/json" -d '{"sku":"10","quantity":"10", "type":"increase"}' -X PUT localhost:8080/products
  // show dbs
  // show collections
  // db.test_table.find( {} )
  // db.test_table.find( { _id: "2" } )

  @Autowired
  private InventoryRepository repository;

  Logger logger = LoggerFactory.getLogger(this.getClass());

  public List<Inventory> list() {
    // report
    return repository.findAll();
  }

  @Transactional
  public List<Inventory> getInventory() {
    logger.debug("Retrieving all products");

    // Get the latest entry for each product by grouping them by sku and sorting by timestamp
    List<Inventory> inventory = Lists.newArrayList(repository.findAll()
        .stream()
        .collect(Collectors.toMap(Inventory::getSku, Function.identity(),
            BinaryOperator.maxBy(comparingLong(Inventory::getTimestamp))))
        .values());

    logger.info("Found {} product(s) in inventory", inventory.size());
    return inventory;
  }

  public Inventory get(String sku) {
    logger.debug("Retrieving sku: {}", sku);
    return repository.findTopBySkuOrderByTimestampDesc(sku);
  }

  @Transactional
  public Inventory update(Update update) {
    Inventory inventory = newInventoryEntry(update.getSku());

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

  @Transactional
  public Inventory delete(Delete delete) {
    Inventory inventory = newInventoryEntry(delete.getSku());
    inventory.setStatus(INACTIVE);
    return repository.save(inventory);
  }

  private Inventory newInventoryEntry(String sku) {
    Inventory previous = repository.findBySku(sku);
    Inventory inventory = new Inventory();
    inventory.setSku(sku);
    if (previous != null) {
      inventory.setQuantity(previous.getQuantity());
      inventory.setStatus(previous.getStatus());
    }

    return inventory;
  }
}
