package com.tdd;

public class Item {
    private String name;
    private boolean exempt;
    private double price;

    public Item(String name, boolean exempt, double price) {
        this.name = name;
        this.exempt = exempt;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public boolean getExempt(){
        return this.exempt;
    }

    public double getPrice() {
        return this.price;
    }
    public void setPrice(double newPrice){
        this.price = newPrice;
    }
}
