package com.worldNavigator;

import com.worldNavigator.mapBuilder.Map1Builder;
import com.worldNavigator.mapObjects.Player;

import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        Game newgame = new Game();
        newgame.homePage();

        /*Player Hamza = Map1Builder.getInstance().buildLevel();
        Hamza.Look();
        System.out.println(Hamza.getCurrentRoom());
        Hamza.rotateRight();
        Hamza.Look();
        Hamza.moveForward();
        System.out.println(Hamza.getCurrentRoom());
        Hamza.rotateLeft();
        Hamza.Look();*/
    }
}
