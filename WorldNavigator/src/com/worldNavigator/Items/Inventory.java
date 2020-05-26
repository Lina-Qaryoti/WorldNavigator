package com.worldNavigator.Items;

import com.worldNavigator.Trade;

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

    public void listItemswithPrices(Trade prices){
        for( Item item : inventory){
            System.out.println(item.getDescription()+" Price: "+prices.getPrice(item));
        }
    }

    public void listItems(){
        for( Item item : inventory){
            System.out.println(item.getDescription());
        }
    }

    public Optional<Flashlight> getFlashlight(){
        for(Item item: inventory){
            if(item instanceof Flashlight)
                return Optional.of((Flashlight)item);
        }
        return Optional.empty();
    }

    public Item getItem(int num){
        if(inRange(num)){
            Item obj= inventory.get(num);
            return obj;
        }
        else
            return null;
    }

    public boolean inRange(int num){
        return (num>0 && num<=inventory.size());
    }


}
