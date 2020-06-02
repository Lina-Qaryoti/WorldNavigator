package com.worldNavigator.mapObjects;

import com.worldNavigator.Direction;
import com.worldNavigator.Items.*;
import com.worldNavigator.Trade;
import com.worldNavigator.Exceptions.WinningException;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Player extends Exception {
    private Room currentRoom;
    private Direction playerOrientation;
    private Gold gold= new Gold(0.0);
    private Inventory playerInventory= new Inventory();
    private Trade trading;

    public double getGold() {
        return gold.getAmount();
    }

    public void transaction(double balance){
        gold.setAmount(gold.getAmount()+balance);
    }

    public Inventory getPlayerInventory() {
        return playerInventory;
    }

    public void printRoomNumber(){
        System.out.println("Room #"+getCurrentRoom());
    }

    public int getCurrentRoom() {
        return currentRoom.getRoomNo();
    }


    public Player(double initialGold, Trade trading){
        if(initialGold>=0)
            gold.setAmount(initialGold);

        playerOrientation=Direction.North;
        this.trading=trading;
    }

    public Player(double initialGold, List<Item> items, Trade trading){
        if(initialGold>=0)
            gold.setAmount(initialGold);

        playerInventory.addItems(items);
        playerOrientation=Direction.North;
        this.trading=trading;
    }


    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void playerStatus(){
        System.out.println("Player is facing "+ playerOrientation.name());
        System.out.println(gold.getDescription());
        System.out.println("Items in player inventory:");
        playerInventory.listItems();
    }

    public void moveForward() throws WinningException {
        MapObjects obj= currentRoom.getSide(playerOrientation);
        if(obj instanceof GenericDoor){
            if(obj instanceof ExitDoor && ((ExitDoor) obj).isOpen()) {
                throw new WinningException();
            }
            if (((GenericDoor) obj).isOpen())
                currentRoom=((StandardDoor) obj).otherSide(currentRoom);
            else
                System.out.println("Door is Locked");
        }

        else
            System.out.println("Not facing a Door");

    }

    public void moveBackward() throws WinningException {
        MapObjects obj= currentRoom.getSide(playerOrientation.getBackwardsDirection());
        if(obj instanceof GenericDoor){
            if(obj instanceof ExitDoor) {
                throw new WinningException();
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

    public void Look() throws WinningException{
        if(!canSee()){
            System.out.println("Dark");
        }
        else{
            currentRoom.getSide(playerOrientation).getDescription();
        }
    }

    public void Check(){
        if(!currentRoom.getSide(playerOrientation).isCheckable()) {
            System.out.println("This object cannot be checked");
            return;
        }
        else{
            List<Item> itemsFound= currentRoom.getSide(playerOrientation).checkObject();
            for( Item item : itemsFound){
                if(item.getClass()==Gold.class)
                    transaction(((Gold) item).getAmount());

                else
                    playerInventory.addItem(item);

            }
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
        if(flashlight.isPresent()) {
            flashlight.get().pressButton();
        }
        else
            System.out.println("No flashlight in inventory");
    }

    public void SwitchLights(){
        if(currentRoom instanceof RoomWithLightSwitch)
            ((RoomWithLightSwitch) currentRoom).switchLights();
        else
            System.out.println("Room does not have light switch");
    }

    public void Open(){
        Wall object = currentRoom.getSide(playerOrientation);
        if(object instanceof GenericDoor){
            if(!((GenericDoor) object).isOpen())
                ((GenericDoor) object).unlockDoor();
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

    public void Buy(){
        trading.Buy(this,(Seller)currentRoom.getSide(playerOrientation));
    }

    public void Sell(){
        trading.Sell(this,(Seller)currentRoom.getSide(playerOrientation));
    }

    public void List(){
        trading.List((Seller)currentRoom.getSide(playerOrientation));
    }

    public void finishTrade(){
        trading.setTradingMode(false);
    }

    public void useKey(){
        Scanner sc= new Scanner(System.in);
        String keyName= sc.next();

        Wall obj= currentRoom.getSide(playerOrientation);
        Key key=playerInventory.keyExists(keyName);
        if(key==null) {
            System.out.println("Player does not have key in inventory");
            return;
        }
        if(obj instanceof GenericDoor)
            ((GenericDoor) obj).useKey(key);
        else if (obj instanceof Chest)
            ((Chest) obj).useKey(key);
        else
            System.out.println("cannot use key on this object");
    }
}
