package com.worldNavigator.mapObjects;

import com.worldNavigator.Items.*;
import com.worldNavigator.Trade;
import java.util.List;

public class Seller extends WallDecorator {

  private Trade trading;
  private Inventory sellerInventory = new Inventory();

  public Inventory getSellerInventory() {
    return sellerInventory;
  }

  public Seller(Wall wall, Trade trading) {
    super(wall);
    this.trading = trading;
  }

  public void addItems(List<Item> items) {
    sellerInventory.addItems(items);
  }

  @Override
  public void getDescription() {
    System.out.println("Seller");
  }

  public void listItems() {
    sellerInventory.listItemsWithPrices(trading);
  }
}
