package com.worldNavigator.mapBuilder;

import com.worldNavigator.Trade;
import com.worldNavigator.mapObjects.Player;

public class Map1Builder extends MapCreationTemplate {

    private static Map1Builder level = new Map1Builder();

    private Map1Builder(){

    }

    @Override
    protected MapBuilder createMapBuilder() {
        return new StandardMapBuilder();
    }

    @Override
    protected Map createMap(MapBuilder builder) {
        return  MapDesigner.getMap1(builder);
    }

    @Override
    protected Player createPlayer(Trade trade) {
        return new Player(50,trade);
    }

    @Override
    protected void endGame(MapBuilder builder, Map map, Player player) {
        builder=null;
        map=null;
        player=null;
        System.out.println("Would you like to start over?");

    }

    public static Map1Builder getInstance(){
        return level;
    }
}
