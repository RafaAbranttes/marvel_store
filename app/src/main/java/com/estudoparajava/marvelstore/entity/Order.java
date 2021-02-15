package com.estudoparajava.marvelstore.entity;

//classe inicialmente gereada para colocar os pedidos
//depois salvar no celular internamente (nao foi implementado)

public class Order {

    private Integer id;
    private Integer quantity;
    private String imageURl;
    private String price;
    private String cupom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImageURl() {
        return imageURl;
    }

    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCupom() {
        return cupom;
    }

    public void setCupom(String cupom) {
        this.cupom = cupom;
    }



}
