package com.worldNavigator.mapObjects;


import com.worldNavigator.Items.Item;
import com.worldNavigator.Items.Key;

import java.util.ArrayList;
import java.util.List;

public class Chest extends WallDecorator {

    private boolean chestOpen;
    private Key key;
    List <Item> chestInventory= new ArrayList<Item>();

    public Chest(Wall wall){
        super(wall);
        chestOpen = true;
    }

    public Chest(Wall wall, Key key){
        super(wall);
        chestOpen = false;
        this.key= key;
    }

    public Chest(Wall wall, Key key, List <Item> items){
        super(wall);
        chestOpen = false;
        this.key= key;
        chestInventory= items;
    }

    public Chest(Wall wall, List <Item> items){
        super(wall);
        chestOpen = false;
        chestInventory= items;
    }


    public boolean isOpen(){
        return chestOpen;
    }

    public void openChest(){
        chestOpen= true;
    }

    public void closeChest(){
        chestOpen= false;
    }

    @Override
    public boolean isCheckable() {
        return true;
    }

    @Override
    public void getDescription() {
        System.out.println("Chest");
    }

    @Override
    public List<Item> checkObject(){
        List <Item> items= new ArrayList<Item>();
        if(!isOpen()){
            System.out.println("chest closed "+key.getName()+" key is required to unlock");
        }
        else if(chestInventory.isEmpty()){
            System.out.println("No items found inside chest");
        }
        else{
            System.out.println("Items found inside chest:");
            //Use iterable ?!!?!
        }
        return items;
    }
}
