package com.worldNavigator;

public enum Direction {
    North, East, South, West;

    public Direction getBackwardsDirection(){
        return values()[(this.ordinal()+2)%4];
    }

    public Direction getLeftDirection(){
        return values()[(this.ordinal()+3)%4];
    }

    public Direction getRightDirection(){
        return values()[(this.ordinal()+1)%4];
    }
}
