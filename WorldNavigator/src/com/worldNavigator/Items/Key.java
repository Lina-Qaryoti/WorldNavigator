package com.worldNavigator.Items;

public class Key extends Item {
    private String name;
    private Double price;

    public Key(String name){
        this.name= name;
    }


    public String getName(){
        return name;
    }

    @Override
    public String getDescription() {
        return "Key "+getName();
    }


}
