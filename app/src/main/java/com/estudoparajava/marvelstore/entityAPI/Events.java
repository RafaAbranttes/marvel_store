package com.estudoparajava.marvelstore.entityAPI;

import java.util.List;

public class Events {

    private int available;
    private String collectionURI;
    private List<ItemsEvents> items;
    private int returned;

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<ItemsEvents> getItems() {
        return items;
    }

    public void setItems(List<ItemsEvents> items) {
        this.items = items;
    }
}
