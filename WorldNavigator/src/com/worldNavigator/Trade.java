package com.worldNavigator;

import com.worldNavigator.Items.Item;
import com.worldNavigator.mapObjects.Player;
import com.worldNavigator.mapObjects.Seller;

import java.util.HashMap;
import java.util.Map;

public class Trade {
    private HashMap<Class<? extends Item>, Double> itemsPrices = new HashMap<>();

    public boolean isTradingMode() {
        return tradingMode;
    }

    public void setTradingMode(boolean tradingMode) {
        this.tradingMode = tradingMode;
    }

    private boolean tradingMode;

    public Trade(){
        tradingMode=false;
    }

    public void put(Class <? extends Item> object ,Double price){
        itemsPrices.put(object,price);
    }

    public Double getPrice(Class <? extends Item> object ){
        return itemsPrices.getOrDefault(object,0.0);
    }

    public void listItemPrices(){
        for (Map.Entry<Class <? extends Item> ,Double> entry : itemsPrices.entrySet()) {
            String object = entry.getKey().getName();
            Double price = entry.getValue();
            System.out.println(object + " : " + price + " gold coins");
        }
    }

    public void Buy(int itemNum, Player player, Seller seller){
        if(seller.inRange(itemNum)){
            Item object= seller.getItem(itemNum);
            double price = getPrice(object.getClass());
            if(player.getGold()<price){
                System.out.println("Return when you have enough gold");
            }
            else{
                seller.getSellerInventory().remove(object);
                player.getPlayerInventory().addItem(object);
                player.transaction(-price);
                System.out.println(object.getDescription()+" bought and acquired");
            }
        }
        else
            System.out.println("Item number not in range");
    }

}
