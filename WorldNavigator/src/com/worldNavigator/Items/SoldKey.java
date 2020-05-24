package com.worldNavigator.Items;

public class SoldKey extends Key {

    private Double price;

    public SoldKey(String name, Double price) {
        super(name);
        this.price=price;
    }

    public Double getPrice(){
        return price;
    }
}
