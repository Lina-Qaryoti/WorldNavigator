package com.worldNavigator.mapBuilder;

import com.worldNavigator.Trade;
import com.worldNavigator.mapBuilder.Map;
import com.worldNavigator.mapBuilder.MapBuilder;
import com.worldNavigator.mapObjects.Player;

public abstract class MapCreationTemplate {
    public final Player buildLevel(){
        MapBuilder builder= createMapBuilder();
        Map map=createMap(builder);
        Player player = createPlayer(map.getTrading());
        player.setCurrentRoom(map.getStartRoom());

        return player;
    }

    protected abstract MapBuilder createMapBuilder();
    protected abstract Map createMap(MapBuilder builder);
    protected abstract Player createPlayer(Trade trade);

}
