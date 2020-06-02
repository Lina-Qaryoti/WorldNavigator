package com.worldNavigator;

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
            if (seller.getSellerInventory().inRange(itemNum)) {
                Item object = seller.getSellerInventory().getItem(itemNum);
                double price = getPrice(object);
                if (player.getGold() < price)
                    System.out.println("Return when you have enough gold");
                else {
                    seller.getSellerInventory().removeFromInventory(object);
                    player.getPlayerInventory().addItem(object);
                    player.transaction(-price);
                    System.out.println(object.getDescription() + " bought and acquired");
                }
            }
            else
                System.out.println("Item number not in range");
        }
    }

    public void Sell( Player player, Seller seller){
        if(canTrade()) {
            listItemPrices();
            Scanner sc= new Scanner(System.in);
            int itemNum=sc.nextInt();
            if (player.getPlayerInventory().inRange(itemNum)) {
                Item object = player.getPlayerInventory().getItem(itemNum);
                double price = getPrice(object);
                seller.getSellerInventory().addItem(object);
                player.getPlayerInventory().removeFromInventory(object);
                player.transaction(price);
                System.out.println(object.getDescription() + " sold");
            }
            else
                System.out.println("Item number not in range");
        }
    }

    public void List(Seller seller){
        if(canTrade())
            seller.listItems();
    }

}
