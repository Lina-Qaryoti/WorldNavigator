package com.worldNavigator.mapObjects;

import com.worldNavigator.Items.Item;
import java.util.List;

public class Wall extends MapObjects {

  public Wall() {}

  public void getDescription() {
    System.out.println("Wall");
  }

  public boolean isCheckable() {
    return false;
  }

  public List<Item> checkObject() {
    return null;
  }
}
