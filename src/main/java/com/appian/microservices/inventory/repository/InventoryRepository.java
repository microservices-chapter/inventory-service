package com.appian.microservices.inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<Inventory, String> {

  Inventory findBySku(String sku);

  Inventory findTopBySkuOrderByTimestampDesc(String sku);

}
