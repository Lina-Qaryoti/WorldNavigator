package com.worldNavigator.mapBuilder;

import com.worldNavigator.Direction;
import com.worldNavigator.mapObjects.*;

import java.security.InvalidParameterException;

public class StandardMapBuilder implements MapBuilder {

    private Map m;

    public Direction commonWall(int r1, int r2){
        if(r2==m.getNorth(r1))
            return Direction.North;
        else if(r2==m.getEast(r1))
            return Direction.East;
        else if(r2==m.getSouth(r1))
            return Direction.South;
        else if(r2==m.getWest(r1))
            return Direction.West;

        else return null;

    }

    @Override
    public void buildMap(int rows,int columns) {
        m= new Map(rows,columns);
    }

    @Override
    public void buildRoom(int roomNO, int row,int column) {
        Room r=new Room(roomNO,row,column);
        m.addRoom(r);

        r.setSide(Direction.West,new Wall());
        r.setSide(Direction.South,new Wall());
        r.setSide(Direction.East,new Wall());
        r.setSide(Direction.North,new Wall());

    }

    @Override
    public void buildDoor(int r1, int r2) {
        //maybe implement try catch ??
        Room fromRoom=m.getRoom(r1);
        Room toRoom=m.getRoom(r2);
        Wall w=new Wall();
        StandardDoor d= new StandardDoor(w,fromRoom,toRoom);

        if(null==commonWall(r1,r2)){
            throw new InvalidParameterException("Cannot create a door between these two rooms");
        }

        fromRoom.setSide(commonWall(r1,r2), d);
        toRoom.setSide(commonWall(r2,r1),d);
    }

    @Override
    public void setStartRoom(int roomNo) {
        m.setStartRoom(roomNo);
    }

    @Override
    public void setMapDuration(long durationOfGame) {
        m.setGameDuration(durationOfGame);
    }

    @Override
    public void buildPainting(int roomNo, Direction direction) {
        Room room = m.getRoom(roomNo);
        Wall painting= new Painting(room.getSide(direction));
        room.setSide(direction, painting);
    }

    @Override
    public void buildSeller(int roomNo, Direction direction) {
        Room room=m.getRoom(roomNo);
        Wall seller= new Seller(room.getSide(direction),m.getTrading());
        room.setSide(direction, seller);
    }

    @Override
    public void buildChest(int roomNo, Direction direction) {
        Room room= m.getRoom(roomNo);
        Wall chest= new Chest(room.getSide(direction));
        room.setSide(direction, chest);
    }

    @Override
    public void buildMirror(int roomNo, Direction direction) {
        Room room= m.getRoom(roomNo);
        Wall mirror= new Mirror(room.getSide(direction));
        room.setSide(direction, mirror);
    }


    @Override
    public Map getMap() {
        return m;
    }
}
