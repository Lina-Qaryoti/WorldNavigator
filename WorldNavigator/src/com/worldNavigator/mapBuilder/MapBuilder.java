package com.worldNavigator.mapBuilder;

import com.worldNavigator.*;
import com.worldNavigator.Items.*;
import com.worldNavigator.mapObjects.*;


public interface MapBuilder {


    void buildMap(int rows,int columns);
    void setMapDuration(long durationOfGame);
    void setMapItemsPrices(Class <? extends Item> object , Double price);

    void buildRoom(int roomNO,int row,int column);
    void buildRoomWithLightSwitch(int roomNo, int row, int column);
    void buildDarkRoom(int roomNo,int row, int column);
    Room getRoom(int roomNo);

    void buildDoor(int r1, int r2);
    void buildClosedDoor(int r1, int r2);
    void buildLockedDoor(int r1, int r2, Key key);
    void buildExitDoor(Direction direction, int roomNo);
    void buildLockedExitDoor(Direction direction, int roomNo, Key key);

    void setStartRoom(int roomNo);

    void buildPainting(int roomNo, Direction direction);
    void buildKeyInPainting(Painting painting, Key key);

    Seller buildSeller(int roomNo, Direction direction);
    void buildSellerInventory();
    void addItemToSellerInventory(Item item);
    void addSellerInventoryToSeller(Seller seller);

    void buildChest(int roomNo, Direction direction);

    Key buildKey(String keyName);
    Key buildPricedKey(String keyName, Double price);

    Wall getWallObject(int roomNo, Direction direction);

    void buildMirror(int roomNo, Direction direction);
    void buildKeyInMirror(Mirror mirror, Key key);

    void buildChestInventory();
    void addItemToChestInventory(Item item);
    void buildChestWithInventory(int roomNo, Direction direction);
    void buildChestWithKey(int roomNo, Direction direction, Key key);
    void buildChestWithInventoryAndKey(int roomNo, Direction direction, Key key);

    Map getMap();
}
