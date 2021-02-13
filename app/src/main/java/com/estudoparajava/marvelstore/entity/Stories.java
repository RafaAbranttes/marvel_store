package com.estudoparajava.marvelstore.entity;

import java.util.List;

public class Stories {

    private int available;
    private String collectionURI;
    private List<ItemsStories> items;
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

    public List<ItemsStories> getItems() {
        return items;
    }

    public void setItems(List<ItemsStories> items) {
        this.items = items;
    }
}
