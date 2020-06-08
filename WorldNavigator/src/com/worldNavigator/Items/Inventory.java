package com.worldNavigator.Items;

import com.worldNavigator.Trade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventory {
    private List<Item> inventory = new ArrayList<>();

    public void addItem(Item item){
        inventory.add(item);
    }

    public List<Item> getInventory(){
        return inventory;
    }

    public void emptyInventory(){
        inventory=null;
    }

    public void addItems(List <Item> items){
        for(Item item : items) {
            addItem(item);
        }
    }

    public void removeFromInventory(Item item){
       inventory.remove(item);
    }

    public void listItemsWithPrices(Trade prices){
        for( Item item : inventory){
            System.out.println(item.getDescription()+" Price: "+prices.getPrice(item));
        }
    }

    public boolean isEmpty(){
        return inventory.isEmpty();
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
            return inventory.get(num-1);
        }
        else
            return null;
    }

    public Key keyExists(String keyName){
        for(Item item: inventory){
            if(item instanceof Key && keyName.equals(((Key) item).getName()))
                return (Key) item;
        }
        return null;
    }

    public boolean inRange(int num){
        return (num>0 && num<=inventory.size());
    }


}
