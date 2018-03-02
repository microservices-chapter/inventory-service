package com.appian.microservices.inventory.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Type {

  INCREASE, DECREASE;

  @JsonCreator
  public static Type fromText(String text){
    return Type.valueOf(text.toUpperCase());
  }

  @Override
  public String toString() {
    return this.name().toLowerCase();
  }
}
