package com.worldNavigator.mapObjects;

import com.worldNavigator.Items.*;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericDoor extends WallDecorator {

    private boolean doorOpen;
    private Key key=null;

    public GenericDoor(Wall wall) {
        super(wall);
        doorOpen= true;
    }

    public GenericDoor(Wall wall, Key key){
        super(wall);
        this.key= key;
        doorOpen= false;
    }

    public void openDoor(){
        doorOpen =true;
    }
    public void closeDoor(){ doorOpen = false; }

    public boolean isOpen(){
        return doorOpen;
    }


    @Override
    public boolean isCheckable() {
        return true;
    }

    @Override
    public void getDescription() {
        System.out.println("Door");
    }

    @Override
    public List<Item> checkObject(){
        List <Item> items= new ArrayList<Item>();
        if(isOpen())
            System.out.println("Door is open");
        else
            System.out.println("Door is locked, "+key.getName()+" key is needed to unlock");
        return null;
    }

}
