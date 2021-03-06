package com.estudoparajava.marvelstore.entityAPI;

public class Prices {

    public Prices(float price) {
        this.price = price;
    }

    private String type;
    private float price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "$" +
                price
                ;
    }
}
