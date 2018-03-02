package com.appian.microservices.inventory;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager {

  @Scheduled(fixedDelay = 5*60*1000L)
  public void checkForLowInventory() {
    // TODO:
    // get product info from catalog service using Feign
    // send notification asynchronously to notification service when inventory is low
  }
}
