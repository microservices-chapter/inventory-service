package com.appian.microservices.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appian.microservices.inventory.model.Inventory;

/**
 * Inventory application.
 *
 * @author touré
 */
@SpringBootApplication
@RestController
@Configuration
@ComponentScan
public class InventoryApplication {

  @Autowired
  InventoryService inventoryService;

  @RequestMapping(value = "/inventory")
  public @ResponseBody List<Inventory> getAll() {
    return inventoryService.getAll();
  }

  @RequestMapping(value = "/inventory/{productId}")
  public @ResponseBody Inventory getInventory(@PathVariable String productId) {
    return inventoryService.get(productId);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/inventory", consumes = "application/json")
  public @ResponseBody List<Inventory> updateInventory(@RequestBody List<Inventory> items) {
    return inventoryService.update(items);
  }

  public static void main(String[] args) {
    SpringApplication.run(InventoryApplication.class, args);
  }
}
