package com.example.binusezyfood;

public class Drink {

    private String name;
    private Integer price;
    private int img_id;

    public Drink() {
    }

    public Drink(String name, Integer price, int img_id) {
        this.name = name;
        this.price = price;
        this.img_id = img_id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }
}
