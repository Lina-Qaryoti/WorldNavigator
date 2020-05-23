package com.worldNavigator.mapObjects;

import com.worldNavigator.mapObjects.Wall;

public abstract class WallDecorator extends Wall {
    protected Wall wall;

    protected WallDecorator(Wall wall){
        this.wall=wall;
    }

}
