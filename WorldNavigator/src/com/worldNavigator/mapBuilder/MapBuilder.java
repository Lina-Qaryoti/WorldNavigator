package com.worldNavigator.mapBuilder;

import com.worldNavigator.*;

public interface MapBuilder {


    void buildMap(int rows,int columns);
    void buildRoom(int roomNO,int row,int column);
    void buildDoor(int r1, int r2);
    void setStartRoom(int roomNo);
    void buildPainting(int roomNo, Direction direction);
    void buildSeller(int roomNo, Direction direction);
    void buildChest(int roomNo, Direction direction);
    void buildMirror(int roomNo, Direction direction);
    //void setMapItemsPrices(Class <? extends Item> object , Double price);

    Map getMap();

}
