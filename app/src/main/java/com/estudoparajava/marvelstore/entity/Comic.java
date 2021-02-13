package com.estudoparajava.marvelstore.entity;

import android.media.Image;

import java.util.Date;
import java.util.List;

public class Comic {

    private int id;
    private String title;
    private String description;
    private int pageCoutn;
    private Date date;
    private Image image;
    private List<String> characters;
    private boolean itsRare;

    public Comic(int id, String title, String description, int pageCoutn, Date date, Image image, List<String> characters, boolean itsRare) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pageCoutn = pageCoutn;
        this.date = date;
        this.image = image;
        this.characters = characters;
        this.itsRare = itsRare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageCoutn() {
        return pageCoutn;
    }

    public void setPageCoutn(int pageCoutn) {
        this.pageCoutn = pageCoutn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public boolean isItsRare() {
        return itsRare;
    }

    public void setItsRare(boolean itsRare) {
        this.itsRare = itsRare;
    }


}
