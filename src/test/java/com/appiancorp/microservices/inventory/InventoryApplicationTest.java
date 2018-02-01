package com.appiancorp.microservices.inventory;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.appian.microservices.inventory.InventoryApplication;
import com.appian.microservices.inventory.Product;

public class InventoryApplicationTest {
  @Test
  public void testList() {
    InventoryApplication inventoryApplication = new InventoryApplication();
    List<Product> list = inventoryApplication.list();
    Assert.assertThat(list.size(), CoreMatchers.equalTo(1));
  }
}
