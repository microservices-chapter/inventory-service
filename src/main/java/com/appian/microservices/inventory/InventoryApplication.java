package com.appian.microservices.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appian.microservices.inventory.model.Delete;
import com.appian.microservices.inventory.model.Update;
import com.appian.microservices.inventory.repository.Inventory;

/**
 * Inventory application.
 *
 * @author touré
 */
@SpringBootApplication
@RestController
public class InventoryApplication {

  @Autowired
  private InventoryService inventoryService;

  // TODO: error handling

  @RequestMapping(value = "/products")
  public @ResponseBody List<Inventory> list() {
    return inventoryService.list();
  }

  @RequestMapping(value = "/products/{sku}")
  public @ResponseBody Inventory getInventory(@PathVariable String sku) {
    return inventoryService.get(sku);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Inventory update(@RequestBody Update update) {
    return inventoryService.update(update);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  Delete delete(@RequestBody Delete delete) {
    return inventoryService.delete(delete);
  }

  @RequestMapping(value = "/status")
  public @ResponseBody String health() {
    return "UP";
  }

  public static void main(String[] args) {
    SpringApplication.run(InventoryApplication.class, args);
  }
}
