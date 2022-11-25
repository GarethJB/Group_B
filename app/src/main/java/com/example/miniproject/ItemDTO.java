package com.example.miniproject;

public class ItemDTO {

    private int id, price, qty;
    private String name;

    public ItemDTO(int id, String name, int price, int qty) {
        this.id = id;
        this.price = price;
        this.qty = qty;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
