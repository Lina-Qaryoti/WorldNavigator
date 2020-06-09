package com.worldNavigator.mapBuilder;

import com.worldNavigator.Trade;
import com.worldNavigator.mapObjects.Player;

public class Map2Builder extends MapCreationTemplate {

  private static Map2Builder level = new Map2Builder();

  private Map2Builder() {}

  @Override
  protected MapBuilder createMapBuilder() {
    return new StandardMapBuilder();
  }

  @Override
  protected Map createMap(MapBuilder builder) {
    return MapDesigner.getMap2(builder);
  }

  @Override
  protected Player createPlayer(Trade trade) {
    return new Player(10.0, trade);
  }

  public static Map2Builder getInstance() {
    return level;
  }
}
