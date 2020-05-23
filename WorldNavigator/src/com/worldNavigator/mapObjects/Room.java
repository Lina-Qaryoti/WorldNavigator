package com.worldNavigator.mapObjects;

import com.worldNavigator.Direction;

import java.security.InvalidParameterException;

public class Room {

    private int roomNO;
    private int row,column;
    private Wall[] sides= new Wall[4];
    boolean darkRoom;
    // 0 for north, 1 for east, 2 for south, 3 for west

    public Room(int roomNO, int row, int column){

        this.row=row;
        this.column=column;
        this.roomNO=roomNO;
        darkRoom =false;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getRoomNo(){
        return this.roomNO;
    }


    public Wall getSide(Direction d) {

        if(d!=null)
            return sides[d.ordinal()];
        else
            throw new IllegalArgumentException();
    }

    public boolean isDarkRoom(){
        return darkRoom;
    }


    public void lightUpRoom(){
        darkRoom =false;
    }

    public void setSide(Direction d, Wall obj){
        if(d!=null)
            sides[d.ordinal()]=obj;
        else
            throw new InvalidParameterException("Direction does not exist");
    }

    @Override
    public boolean equals(Object o) {

        if( o instanceof Room){
            if(this.roomNO==((Room) o).roomNO)
                return true;
            else
                return false;
        }
        else
            throw new InvalidParameterException("Cannot compare this object with room");
    }



}