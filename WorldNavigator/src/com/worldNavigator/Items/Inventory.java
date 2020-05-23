package com.worldNavigator.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventory {
    private List<Item> inventory = new ArrayList<Item>();

    public void addItem(Item item){
        inventory.add(item);
    }

    public void addItems(List <Item> items){
        inventory.addAll(items);
    }

    public void removeFromInventory(Item item){
       inventory.remove(item);
    }

    public Optional<Flashlight> getFlashlight(){
        for(Item item: inventory){
            if(item instanceof Flashlight)
                return Optional.of((Flashlight)item);
        }
        return Optional.empty();
    }

    public void listItems(boolean withPrices){

    }



}
