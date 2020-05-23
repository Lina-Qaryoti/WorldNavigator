package com.worldNavigator.mapObjects;

public class RoomWithLightswitch extends Room {

    private boolean lightswitch;

    public RoomWithLightswitch(int roomNO, int row, int column) {
        super(roomNO, row, column);
        lightswitch= true;
    }

    public void switchLights(){
        lightswitch=!lightswitch;
    }

    public boolean isSwitchLit(){
        return lightswitch;
    }

}
