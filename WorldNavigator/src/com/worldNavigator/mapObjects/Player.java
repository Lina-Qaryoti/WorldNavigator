package com.worldNavigator.mapObjects;

import com.worldNavigator.Direction;
import com.worldNavigator.Items.Flashlight;
import com.worldNavigator.Items.Inventory;
import com.worldNavigator.Items.Item;
import com.worldNavigator.Items.Key;
import com.worldNavigator.Trade;

import java.util.List;
import java.util.Optional;

public class Player {
    private Room currentRoom;
    private Direction playerOrientation;
    private double gold;
    private Inventory playerInventory= new Inventory();
    private Trade trading;

    public double getGold() {
        return gold;
    }

    public void transaction(double balance){
        gold+=balance;
    }

    public Inventory getPlayerInventory() {
        return playerInventory;
    }



    public int getCurrentRoom() {
        return currentRoom.getRoomNo();
    }

    public Player(double initialGold, Trade trading){
        if(initialGold>=0)
            gold=initialGold;
        else
            gold=0;

        playerOrientation=Direction.North;
        this.trading=trading;
    }

    public Player(double initialGold, List<Item> items, Trade trading){
        if(initialGold>=0)
            gold=initialGold;
        else
            gold=0;
        playerInventory.addItems(items);
        playerOrientation=Direction.North;
        this.trading=trading;
    }


    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void playerStatus(){
        System.out.println("Player is facing "+ playerOrientation.name());
        System.out.println("Player has "+gold+" gold");
        System.out.println("Items in player inventory:");
        playerInventory.listItems();
    }

    public void moveForward(){
        MapObjects obj= currentRoom.getSide(playerOrientation);
        if(obj instanceof GenericDoor){
            if(obj instanceof ExitDoor && ((ExitDoor) obj).isOpen()) {
                System.out.println("YOU WIN");
                //exit game
            }
            if (((GenericDoor) obj).isOpen())
                currentRoom=((StandardDoor) obj).otherSide(currentRoom);
            else
                System.out.println("Door is Locked");
        }

        else
            System.out.println("Not facing a Door");
    }

    public void moveBackward(){
        MapObjects obj= currentRoom.getSide(playerOrientation.getBackwardsDirection());
        if(obj instanceof GenericDoor){
            if(obj instanceof ExitDoor) {
                System.out.println("YOU WIN");
                //exit game
            }
            if (((StandardDoor) obj).isOpen())
                currentRoom=((StandardDoor) obj).otherSide(currentRoom);
            else
                System.out.println("Door is Closed");
        }
    }

    public void rotateLeft(){
        playerOrientation=playerOrientation.getLeftDirection();
    }

    public void rotateRight(){
        playerOrientation=playerOrientation.getRightDirection();
    }

    public void Look(){
        if(currentRoom.isDarkRoom()){
            System.out.println("Dark");
        }
        else{
            currentRoom.getSide(playerOrientation).getDescription();
        }
    }

    public void Check(){
        if(!currentRoom.getSide(playerOrientation).isCheckable())
            System.out.println("This object cannot be checked");
        else{
            List<Item> itemsFound= currentRoom.getSide(playerOrientation).checkObject();
            playerInventory.addItems(itemsFound);
        }
    }

    private boolean canSee(){
        if(!currentRoom.isDarkRoom())
            return true;
        Optional<Flashlight> flashlight = playerInventory.getFlashlight();
        return flashlight.isPresent() && flashlight.get().isOn();
    }

    public void useFlashLight(){

        Optional<Flashlight> flashlight = playerInventory.getFlashlight();
        if(flashlight.isPresent())
            flashlight.get().pressButton();
        else
            System.out.println("No flashlight in inventory");
    }

    public void SwitchLights(){
        if(currentRoom instanceof RoomWithLightswitch)
            ((RoomWithLightswitch) currentRoom).switchLights();
        else
            System.out.println("Room does not have light switch");
    }

    public void Open(){
        Wall object = currentRoom.getSide(playerOrientation);
        if(object instanceof GenericDoor){
            if(!((GenericDoor) object).isOpen())
                ((GenericDoor) object).openDoor();
            object.checkObject();
        }
        else
            System.out.println("Object cannot be opened");
    }

    public void Trade(){
       if(!trading.isTradingMode()){
           if(currentRoom.getSide(playerOrientation) instanceof Seller){
               trading.setTradingMode(true);
               ((Seller) currentRoom.getSide(playerOrientation)).listItems();
           }
           else{
               System.out.println("Cannot trade this object");
           }
       }
       else{
           System.out.println("You are already in trading mode");
       }
    }

    public void Buy(int itemNum){
        trading.Buy(itemNum,this,(Seller)currentRoom.getSide(playerOrientation));
    }

    public void Sell(int itemNum){
        trading.Sell(itemNum,this,(Seller)currentRoom.getSide(playerOrientation));
    }

    public void List(){
        trading.List((Seller)currentRoom.getSide(playerOrientation));
    }

    public void finishTrade(){
        trading.setTradingMode(false);
    }

    public void useKey(Key key){
        Wall obj= currentRoom.getSide(playerOrientation);
        if(obj instanceof GenericDoor)
            ((GenericDoor) obj).useKey(key);
        else if (obj instanceof Chest)
            ((Chest) obj).useKey(key);
        else
            System.out.println("cannot use key on this object");
    }


}
