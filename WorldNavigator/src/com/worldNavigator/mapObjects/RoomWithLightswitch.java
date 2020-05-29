package com.worldNavigator.mapObjects;

public class RoomWithLightswitch extends Room {

    private boolean lightSwitch;

    public RoomWithLightswitch(int roomNO, int row, int column) {
        super(roomNO, row, column);
        lightSwitch = true;
    }

    public void switchLights(){
        lightSwitch =!lightSwitch;
    }

    public boolean isSwitchLit(){
        return lightSwitch;
    }

}
