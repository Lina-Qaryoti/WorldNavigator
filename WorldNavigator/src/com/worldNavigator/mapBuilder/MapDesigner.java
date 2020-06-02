package com.worldNavigator.mapBuilder;

import com.worldNavigator.*;
import com.worldNavigator.mapObjects.*;
import com.worldNavigator.Items.*;

public class MapDesigner {

        //different maps with different sizes and amount of initial gold for player

    public static Map getMap1(MapBuilder mb){

        mb.buildMap(2,2);
        mb.buildRoom(1,0,0);
        mb.setStartRoom(1);
        mb.setMapDuration(180000); //3 minutes
        mb.buildRoom(2,0,1);
        mb.buildDoor(1,2);
        mb.buildMirror(2, Direction.North);
        mb.buildExitDoor(Direction.East,2);

        return mb.getMap();
    }

    public static Map getMap2(MapBuilder mb){
        mb.buildMap(3,3);
        mb.setMapDuration(300000); //5 minutes
        mb.setMapItemsPrices(Key.class, 30.0);
        mb.setMapItemsPrices(Flashlight.class, 50.0);

        mb.buildRoom(1,0,0);
        mb.setStartRoom(1);
        mb.buildMirror(1,Direction.North);
        Mirror mirror1= (Mirror) mb.getWallObject(1,Direction.North);
        Key chestKey= mb.buildKey("Chest-Key");
        mb.buildKeyInMirror(mirror1,chestKey);

        mb.buildRoom(2,1,0);
        mb.buildDoor(1,2);
        mb.buildMirror(2,Direction.West);
        mb.buildChestInventory();
        mb.addItemToChestInventory(new Flashlight());
        mb.addItemToChestInventory(new Gold(70.0));
        mb.buildChestWithInventoryAndKey(2,Direction.South,chestKey);

        mb.buildRoom(3,1,1);
        mb.buildClosedDoor(2,3);
        Key doorKey4= mb.buildPricedKey("Door4",60.0);
        Seller seller=mb.buildSeller(3,Direction.East);
        mb.buildSellerInventory();
        mb.addItemToSellerInventory(doorKey4);
        mb.addSellerInventoryToSeller(seller);

        mb.buildRoomWithLightSwitch(4,2,1);
        mb.buildLockedDoor(3,4,doorKey4);
        mb.buildPainting(4,Direction.South);
        Painting painting1= (Painting) mb.getWallObject(4,Direction.South);
        Key exitKey= new Key("Exit-Key");
        mb.buildKeyInPainting(painting1,exitKey);

        mb.buildDarkRoom(5,2,2);
        mb.buildDoor(4,5);
        mb.buildLockedExitDoor(Direction.East,5,exitKey);

        return mb.getMap();

    }

}
