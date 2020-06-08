package com.worldNavigator.mapObjects;


public abstract class WallDecorator extends Wall {
    protected Wall wall;

    protected WallDecorator(Wall wall){
        this.wall=wall;
    }

}
