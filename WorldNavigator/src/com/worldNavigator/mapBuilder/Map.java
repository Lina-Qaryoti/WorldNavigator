package com.worldNavigator.mapBuilder;

import com.worldNavigator.Items.Item;
import com.worldNavigator.Trade;
import com.worldNavigator.mapObjects.Room;

import java.security.InvalidParameterException;

public class Map {


    final int rows,columns;
    private Room[][] rooms;
    private Room startRoom;
    private Trade trading;
    private Timer timer;


    public void setItemPrice(Class <? extends Item> object ,Double price){
        trading.put(object,price);
    }

    public Trade getTrading(){
        return trading;
    }

    public Map(int rows, int columns){
        this.rows=rows;
        this.columns=columns;
        rooms= new Room[rows][columns];
        trading= new Trade();
    }

    public void setGameDuration(long durationOfGame){
        timer = new Timer(durationOfGame);
    }

    public void startTimer(){
        timer.run();
    }

    public void addRoom(Room room){
        int row=room.getRow();
        int column=room.getColumn();
        if(row>=0 && row<=rows-1 && column>=0 && column<=columns-1){
            if(rooms[row][column]==null)
                rooms[row][column]=room;
            else
                throw new InvalidParameterException("Room already exists in this position");
        }
        else
            throw new InvalidParameterException("Invalid position for room");

    }

    public Room getRoom(int roomNo){
        for (int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if (rooms[i][j].getRoomNo()==roomNo)
                    return rooms[i][j];
            }
        }
        throw new InvalidParameterException("Room Number does not exist in map");
    }

    public int getNorth(int roomNo){

            Room room = getRoom(roomNo);
            int roomRow=room.getRow();
            int roomColumn=room.getColumn();
            if(roomRow-1>=0 && rooms[roomRow-1][roomColumn]!=null){
                return rooms[roomRow-1][roomColumn].getRoomNo();
            }
            else
                return -1;
    }


    public int getSouth(int roomNo){

        Room room = getRoom(roomNo);
        int roomRow=room.getRow();
        int roomColumn=room.getColumn();
        if(roomRow+1<rows && rooms[roomRow+1][roomColumn]!=null){
            return rooms[roomRow+1][roomColumn].getRoomNo();
        }
        else
            return -1;
    }

    public int getEast(int roomNo){

        Room room = getRoom(roomNo);
        int roomRow=room.getRow();
        int roomColumn=room.getColumn();
        if(roomColumn+1<columns && rooms[roomRow][roomColumn+1]!=null){
            return rooms[roomRow][roomColumn+1].getRoomNo();
        }
        else
            return -1;
    }

    public int getWest(int roomNo){

        Room room = getRoom(roomNo);
        int roomRow=room.getRow();
        int roomColumn=room.getColumn();
        if(roomColumn-1>=0 && rooms[roomRow][roomColumn-1]!=null){
            return rooms[roomRow][roomColumn-1].getRoomNo();
        }
        else
            return -1;
    }

    public Room getStartRoom() {
        return startRoom;
    }

    public void setStartRoom(int roomNO) {
        this.startRoom = getRoom(roomNO);
    }
}
