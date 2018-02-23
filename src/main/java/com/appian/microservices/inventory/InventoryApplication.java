package com.appian.microservices.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class InventoryApplication {

  @RequestMapping(value = "/inventory")
  public @ResponseBody List<Inventory> listAll() {
    List<Inventory> l = new ArrayList<>();
    l.add(new Inventory(UUID.randomUUID().toString(), 3));
    l.add(new Inventory(UUID.randomUUID().toString(), 2));
    return l;
  }

  @RequestMapping(value = "/inventory/{productId}")
  public @ResponseBody Inventory getInventory(@PathVariable String productId) {
    return null;
  }

  @RequestMapping(method = RequestMethod.POST, value = "/inventory", consumes = "application/json")
  public @ResponseBody List<Inventory> updateInventory(@RequestBody List<Inventory> update) {
    return null;
  }

  public static void main(String[] args) {
    SpringApplication.run(InventoryApplication.class, args);
  }
}
