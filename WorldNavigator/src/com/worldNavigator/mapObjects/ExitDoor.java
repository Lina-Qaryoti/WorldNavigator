package com.worldNavigator.mapObjects;

import com.worldNavigator.Items.Key;

public class ExitDoor extends GenericDoor {

    private Room room;

    public ExitDoor(Wall wall, Room room) {
        super(wall);
        this.room= room;
    }

    public ExitDoor(Wall wall, Room room, Key key) {
        super(wall, key);
        this.room= room;
    }



}
