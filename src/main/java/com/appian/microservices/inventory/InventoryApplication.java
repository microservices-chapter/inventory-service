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

import com.appian.microservices.inventory.model.DeleteRequest;
import com.appian.microservices.inventory.model.Inventory;
import com.appian.microservices.inventory.model.UpdateRequest;

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

  // TODO: handle errors and exceptions

  @RequestMapping(value = "/product")
  public @ResponseBody List<Inventory> list() {
    return inventoryService.list();
  }

  @RequestMapping(value = "/product/{productId}")
  public @ResponseBody Inventory getInventory(@PathVariable String productId) {
    return inventoryService.get(productId);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Inventory update(@RequestBody
      UpdateRequest updateRequest) {
    return inventoryService.update(updateRequest);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody DeleteRequest delete(@RequestBody
      DeleteRequest deleteRequest) {
    return inventoryService.delete(deleteRequest);
  }

  @RequestMapping(value = "/status")
  public @ResponseBody String health() {
    return "UP";
  }

  public static void main(String[] args) {
    SpringApplication.run(InventoryApplication.class, args);
  }
}
