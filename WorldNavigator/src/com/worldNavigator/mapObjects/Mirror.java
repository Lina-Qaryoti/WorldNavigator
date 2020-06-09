package com.worldNavigator.mapObjects;

import com.worldNavigator.Items.*;
import java.util.ArrayList;
import java.util.List;

public class Mirror extends WallDecorator {

  Key key = null;

  public Mirror(Wall wall) {
    super(wall);
  }

  public void hideKey(Key key) {
    this.key = key;
  }

  public boolean hasKey() {
    return key != null;
  }

  @Override
  public void getDescription() {
    System.out.println("You see a silhouette of you");
  }

  @Override
  public boolean isCheckable() {
    return true;
  }

  @Override
  public List<Item> checkObject() {
    List<Item> items = new ArrayList<>();
    if (hasKey()) {
      items.add(key);
      System.out.println("The " + key.getName() + " key was acquired");
      key = null;
    }
    return items;
  }
}
