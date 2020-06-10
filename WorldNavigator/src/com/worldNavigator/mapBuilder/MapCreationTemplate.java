package com.worldNavigator.mapBuilder;

import com.worldNavigator.Trade;
import com.worldNavigator.mapObjects.Player;

public abstract class MapCreationTemplate {

  private long durationOfGame;

  public final Player buildLevel() {
    MapBuilder builder = createMapBuilder();
    Map map = createMap(builder);
    map.printMap();
    durationOfGame = map.getMapDuration();
    Player player = createPlayer(map.getTrading());
    player.setCurrentRoom(map.getStartRoom());
    return player;
  }

  public long getDurationOfGame() {
    return durationOfGame;
  }

  protected abstract MapBuilder createMapBuilder();

  protected abstract Map createMap(MapBuilder builder);

  protected abstract Player createPlayer(Trade trade);
}
