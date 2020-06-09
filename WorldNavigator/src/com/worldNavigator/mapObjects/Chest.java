package com.worldNavigator.mapObjects;

import com.worldNavigator.Items.*;
import java.util.ArrayList;
import java.util.List;

public class Chest extends WallDecorator {

  private boolean chestOpen;
  private Lock lock;
  Inventory chestInventory = new Inventory();

  public Chest(Wall wall) {
    super(wall);
    chestOpen = true;
  }

  public Chest(Wall wall, Key key) {
    super(wall);
    chestOpen = false;
    lock = new Lock(key);
  }

  public Chest(Wall wall, Key key, List<Item> items) {
    super(wall);
    chestOpen = false;
    lock = new Lock(key);
    chestInventory.addItems(items);
  }

  public Chest(Wall wall, List<Item> items) {
    super(wall);
    chestOpen = false;
    chestInventory.addItems(items);
  }

  public boolean isOpen() {
    return chestOpen;
  }

  public void openChest() {
    chestOpen = true;
  }

  public void closeChest() {
    chestOpen = false;
  }

  @Override
  public boolean isCheckable() {
    return true;
  }

  public void useKey(Key userKey) {
    if (lock.useKey(userKey)) {
      if (lock.isLocked()) {
        lock.lock();
        closeChest();
        System.out.println("Chest Locked");
      } else {
        lock.unlock();
        openChest();
        System.out.println("Chest Opened");
      }
    } else {
      System.out.println("Key does not match");
    }
  }

  @Override
  public void getDescription() {
    System.out.println("Chest");
  }

  @Override
  public List<Item> checkObject() {
    List<Item> items = new ArrayList<>();

    if (!isOpen()) {
      System.out.println("chest closed " + lock.getKey().getName() + " key is required to unlock");
    } else if (chestInventory.isEmpty()) {
      System.out.println("No items found inside chest");
    } else {
      System.out.println("Items found inside chest:");
      chestInventory.listItems();
      items = chestInventory.getInventory();
      chestInventory.emptyInventory();
    }
    return items;
  }
}
