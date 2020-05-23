package com.worldNavigator.mapBuilder;

import com.worldNavigator.*;

public class MapDesigner {

        //different maps with different sizes and amount of initial gold for player

    public static Map getMap1(MapBuilder mb){

        mb.buildMap(3,3);
        mb.buildRoom(1,0,0);
        mb.setStartRoom(1);
        mb.buildRoom(2,0,1);
        mb.buildDoor(1,2);
        mb.buildMirror(2, Direction.North);

        return mb.getMap();
    }


}
