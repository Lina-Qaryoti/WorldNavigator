package com.worldNavigator.mapObjects;

import com.worldNavigator.Items.Item;
import com.worldNavigator.Trade;
import com.worldNavigator.mapObjects.Wall;
import com.worldNavigator.mapObjects.WallDecorator;

import java.util.ArrayList;
import java.util.List;

public class Seller extends WallDecorator {

    private Trade trading;

    public List<Item> getSellerInventory() {
        return sellerInventory;
    }

    private List<Item> sellerInventory = new ArrayList<Item>();

    public Seller(Wall wall, Trade trading){
        super(wall);
        this.trading=trading;
    }

    public void addItem(Item item){
        sellerInventory.add(item);
    }

    @Override
    public void getDescription() {
        System.out.println("Seller");
    }

    public void listItems(){
        for( Item item : sellerInventory){
            System.out.println(item.getDescription()+" Price: "+trading.getPrice(item.getClass()));
        }
    }

    public boolean inRange(int num){
        return (num>0 && num<=sellerInventory.size());
    }

    public Item getItem(int num){
        return sellerInventory.get(num);
    }


}
