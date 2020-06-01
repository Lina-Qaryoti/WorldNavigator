package com.worldNavigator.mapBuilder;

import com.worldNavigator.Trade;
import com.worldNavigator.mapObjects.Player;

public abstract class MapCreationTemplate {

    public final Player buildLevel(){
        MapBuilder builder= createMapBuilder();
        Map map=createMap(builder);
        map.printMap();
        Player player = createPlayer(map.getTrading());
        player.setCurrentRoom(map.getStartRoom());
        //map.startTimer();
        return player;
    }

    protected abstract MapBuilder createMapBuilder();
    protected abstract Map createMap(MapBuilder builder);
    protected abstract Player createPlayer(Trade trade);

}
