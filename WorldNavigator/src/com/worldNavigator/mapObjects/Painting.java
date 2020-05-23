package com.worldNavigator.mapObjects;

import com.worldNavigator.Items.Item;
import com.worldNavigator.Items.Key;

import java.util.ArrayList;
import java.util.List;

public class Painting extends WallDecorator {

    Key key= null;

    public Painting(Wall wall){
        super(wall);
    }

    public void hideKey(Key key){
        this.key= key;
    }

    public boolean hasKey(){
        if (key!=null)
            return true;
        return false;
    }

    @Override
    public void getDescription() {
        System.out.println("Painting");
    }

    @Override
    public boolean isCheckable() {
        return true;
    }

    @Override
    public List<Item> checkObject(){
        List <Item> items= new ArrayList<Item>();
        if(hasKey()) {
            items.add(key);
            System.out.println("The "+key.getName()+" key was acquired");
        }
        return items;
    }
}
