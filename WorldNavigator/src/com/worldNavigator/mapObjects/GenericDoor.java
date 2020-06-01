package com.worldNavigator.mapObjects;

import com.worldNavigator.Items.*;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericDoor extends WallDecorator {

    private boolean doorOpen;
    private Lock lock;

    public GenericDoor(Wall wall) {
        super(wall);
        doorOpen= true;
    }

    public GenericDoor(Wall wall, Key key){
        super(wall);
        lock=new Lock(key);
        doorOpen= false;
    }

    public void openDoor(){
        if(lock==null)
            doorOpen =true;
    }
    public void closeDoor(){ doorOpen = false; }

    public boolean isOpen(){
        if(lock==null)
            return doorOpen;
        else
            return lock.isLocked();
    }


    public void useKey(Key userKey){
        if(lock.useKey(userKey)){
            if(lock.isLocked()){
                System.out.println("Door Locked");
            }
            else
                System.out.println("Door Opened");
        }
        else
            System.out.println("Key does not match");
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
        if(lock!=null && lock.isLocked())
            System.out.println("Door is locked, "+lock.getKey().getName()+" key is needed to unlock");
        else if(!doorOpen)
            System.out.println("Door is locked");
        else
            System.out.println("Door is open");
        return null;
    }

}
