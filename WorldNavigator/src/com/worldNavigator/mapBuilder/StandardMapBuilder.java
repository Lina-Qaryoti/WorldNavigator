package com.worldNavigator.mapBuilder;

import com.worldNavigator.Direction;
import com.worldNavigator.Items.Inventory;
import com.worldNavigator.Items.Item;
import com.worldNavigator.Items.Key;
import com.worldNavigator.Items.SoldKey;
import com.worldNavigator.mapObjects.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class StandardMapBuilder implements MapBuilder {

    private Map m;
    private List<Item> chestInventory;
    private List<Item> sellerInventory;

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
    public void buildClosedDoor(int r1, int r2) {
        Room fromRoom=m.getRoom(r1);
        Room toRoom=m.getRoom(r2);
        Wall w=new Wall();
        StandardDoor d= new StandardDoor(w,fromRoom,toRoom);
        d.closeDoor();

        if(null==commonWall(r1,r2)){
            throw new InvalidParameterException("Cannot create a door between these two rooms");
        }

        fromRoom.setSide(commonWall(r1,r2), d);
        toRoom.setSide(commonWall(r2,r1),d);
    }

    @Override
    public void buildLockedDoor(int r1, int r2, Key key) {
        Room fromRoom=m.getRoom(r1);
        Room toRoom=m.getRoom(r2);
        Wall w=new Wall();
        StandardDoor d= new StandardDoor(w,fromRoom,toRoom,key);

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
    public Seller buildSeller(int roomNo, Direction direction) {
        Room room=m.getRoom(roomNo);
        Wall seller= new Seller(room.getSide(direction),m.getTrading());
        room.setSide(direction, seller);
        return (Seller) seller;
    }

    @Override
    public void buildSellerInventory() {
        sellerInventory= new ArrayList<Item>();
    }

    @Override
    public void addItemToSellerInventory(Item item) {
        sellerInventory.add(item);
    }

    @Override
    public void addSellerInventoryToSeller(Seller seller) {
        seller.addItems(sellerInventory);
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
    public Wall getWallObject(int roomNo, Direction direction) {
        return m.getRoom(roomNo).getSide(direction);
    }

    @Override
    public Key buildKey(String keyName) {
        return new Key(keyName);
    }

    @Override
    public Key buildPricedKey(String keyName, Double price) {
        return new SoldKey(keyName,price);
    }


    @Override
    public void buildKeyInMirror(Mirror mirror, Key key) {
        mirror.hideKey(key);
    }

    @Override
    public void setMapItemsPrices(Class<? extends Item> object, Double price) {
        m.setItemPrice(object, price);
    }

    @Override
    public void buildChestInventory() {
        chestInventory= new ArrayList<Item>();
    }

    @Override
    public void addItemToChestInventory(Item item) {
        chestInventory.add(item);
    }

    @Override
    public void buildChestWithInventory(int roomNo, Direction direction) {
        Room room= m.getRoom(roomNo);
        Wall chest= new Chest(room.getSide(direction),chestInventory);
        room.setSide(direction, chest);
    }

    @Override
    public void buildChestWithKey(int roomNo, Direction direction, Key key) {
        Room room= m.getRoom(roomNo);
        Wall chest= new Chest(room.getSide(direction),key);
        room.setSide(direction, chest);
    }

    @Override
    public void buildChestWithInventoryAndKey(int roomNo, Direction direction, Key key) {
        Room room= m.getRoom(roomNo);
        Wall chest= new Chest(room.getSide(direction),key,chestInventory);
        room.setSide(direction, chest);
    }


    @Override
    public Map getMap() {
        return m;
    }
}
