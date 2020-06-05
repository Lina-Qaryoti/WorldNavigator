package com.worldNavigator;

import com.worldNavigator.Items.Inventory;
import com.worldNavigator.Items.Item;
import com.worldNavigator.Items.SoldKey;
import com.worldNavigator.mapObjects.Player;
import com.worldNavigator.mapObjects.Seller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trade {
    private HashMap<Class<? extends Item>, Double> itemsPrices = new HashMap<>();
    private boolean tradingMode;

    public Trade(){
        tradingMode=false;
    }

    public boolean isTradingMode() {
        return tradingMode;
    }

    public void setTradingMode(boolean tradingMode) {
        this.tradingMode = tradingMode;
    }

    public boolean canTrade(){
        if(!isTradingMode()){
            System.out.println("Player must enter trading mode");
            return false;
        }
        return true;
    }

    public void put(Class <? extends Item> object ,Double price){
        itemsPrices.put(object,price);
    }

    public Double getPrice(Item object){
        if(object instanceof SoldKey)
            return ((SoldKey) object).getPrice();
        else
            return itemsPrices.getOrDefault(object.getClass(),0.0);
    }

    /*public Double getPrice(Class <? extends Item> object ){
        return itemsPrices.getOrDefault(object,0.0);
    }*/

    public void listItemPrices(){
        for (Map.Entry<Class <? extends Item> ,Double> entry : itemsPrices.entrySet()) {
            String object = entry.getKey().getSimpleName();
            Double price = entry.getValue();
            System.out.println(object+ " : " + price + " gold coins");
        }
    }


    public void Buy( Player player, Seller seller){
        if(canTrade()) {
            Scanner sc= new Scanner(System.in);
            int itemNum=sc.nextInt();
            Inventory sellerInventory =seller.getSellerInventory();
            if (sellerInventory.inRange(itemNum)) {
                canBuy(player,seller,itemNum);
            }
            else
                System.out.println("Item number not in range");
        }
    }

    private void canBuy( Player player, Seller seller, int itemNum){
        Inventory sellerInventory= seller.getSellerInventory();
        Inventory playerInventory= player.getPlayerInventory();
        Item object = sellerInventory.getItem(itemNum);
        double price = getPrice(object);
        if (player.getGold() < price)
            System.out.println("Return when you have enough gold");
        else {
            sellerInventory.removeFromInventory(object);
            playerInventory.addItem(object);
            player.transaction(-price);
            System.out.println(object.getDescription() + " bought and acquired");
        }
    }

    public void Sell( Player player, Seller seller){
        if(canTrade()) {
            Inventory playerInventory= player.getPlayerInventory();
            listItemPrices();
            Scanner sc= new Scanner(System.in);
            int itemNum=sc.nextInt();
            if (playerInventory.inRange(itemNum)) {
                canSell(player,seller,itemNum);
            }
            else
                System.out.println("Item number not in range");
        }
    }

    private void canSell(Player player, Seller seller, int itemNum){
        Inventory sellerInventory= seller.getSellerInventory();
        Inventory playerInventory= player.getPlayerInventory();
        Item object = playerInventory.getItem(itemNum);
        double price = getPrice(object);
        sellerInventory.addItem(object);
        playerInventory.removeFromInventory(object);
        player.transaction(price);
        System.out.println(object.getDescription() + " sold");
    }

    public void List(Seller seller){
        if(canTrade())
            seller.listItems();
    }

}
