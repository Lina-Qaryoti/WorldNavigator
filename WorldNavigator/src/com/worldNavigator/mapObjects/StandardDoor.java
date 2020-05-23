package com.worldNavigator.mapObjects;

import com.worldNavigator.Items.*;

import java.security.InvalidParameterException;

public class StandardDoor extends GenericDoor {

    private Room room1,room2;

    public StandardDoor(Wall wall, Room room1, Room room2){
        super(wall);
        this.room1=room1;
        this.room2=room2;
    }

    public StandardDoor(Wall wall, Room room1, Room room2, Key key){
        super(wall, key);
        this.room1=room1;
        this.room2=room2;
    }


    public Room otherSide(Room thisRoom){
        if (thisRoom.equals(room1))
            return room2;
        else if (thisRoom.equals(room2))
            return room1;
        throw new InvalidParameterException("Door not on this side of room");
    }

}
