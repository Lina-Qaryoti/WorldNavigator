package com.worldNavigator.Items;

public class SoldKey extends Key {

    private Gold price;

    public SoldKey(String name, Double price) {
        super(name);
        this.price= new Gold(price);
    }

    public Double getPrice(){
        return price.getAmount();
    }
}
