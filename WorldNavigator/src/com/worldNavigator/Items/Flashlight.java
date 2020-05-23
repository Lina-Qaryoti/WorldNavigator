package com.worldNavigator.Items;

import com.worldNavigator.mapObjects.Seller;

public class Flashlight extends Item {
    private boolean button;

    private Flashlight(){
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