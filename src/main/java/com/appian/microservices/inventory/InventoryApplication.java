package com.appian.microservices.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Inventory application.
 *
 * @author touré
 */
@SpringBootApplication
@RestController
public class InventoryApplication {

  @RequestMapping(value = "/products")
  public  @ResponseBody List<Product> list() {
    List<Product> l = new ArrayList<>();
    l.add(new Product(UUID.randomUUID().toString()));
    l.add(new Product(UUID.randomUUID().toString()));
    return l;
  }

  public static void main(String[] args) {
    SpringApplication.run(InventoryApplication.class, args);
  }
}
