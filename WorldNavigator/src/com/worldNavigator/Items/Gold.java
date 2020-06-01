package com.worldNavigator.Items;

public class Gold extends Item{
    private Double amount;

    public Gold(Double amount){
        this.amount=amount;
    }

    public Double getAmount(){
        return amount;
    }

    public void setAmount(Double amount){
        this.amount=amount;
    }

    @Override
    public String getDescription() {
        return "Gold amount= "+amount;
    }

}
