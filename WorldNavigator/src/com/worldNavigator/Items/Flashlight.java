package com.worldNavigator.Items;

public class Flashlight extends Item {
    private boolean button;

    public Flashlight(){
        button= false;
    }

    public boolean isOn(){
        return button;
    }

    public void pressButton(){
        button= !button;
    }

    @Override
    public String getDescription() {
       return "Flashlight";
    }
}
