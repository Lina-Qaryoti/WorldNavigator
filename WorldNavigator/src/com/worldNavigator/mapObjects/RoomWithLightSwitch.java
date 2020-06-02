package com.worldNavigator.mapObjects;

public class RoomWithLightSwitch extends Room {

    private boolean lightSwitch;

    public RoomWithLightSwitch(int roomNO, int row, int column) {
        super(roomNO, row, column);
        lightSwitch = true;
    }

    public void switchLights(){
        lightSwitch =!lightSwitch;
        darkRoom=!darkRoom;
    }

    public boolean isSwitchLit(){
        return lightSwitch;
    }

    public void lightUpRoom(){
        darkRoom=false;
    }
    public void darkenRoom(){
        darkRoom=true;
    }
}
