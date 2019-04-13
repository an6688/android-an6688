package com.example.winetracker;
import java.io.Serializable;

public class Confirmation implements Serializable {
    private String name;
    private String type;
    private String purchasedAt;
    private Double price;
    private Double rating;

    public Confirmation(String name, String type, String purchasedAt, Double price, Double rating) {
        this.name = name;
        this.type = type;
        this.purchasedAt = purchasedAt;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPurchasedAt() {
        return purchasedAt;
    }

    public void setPurchsedAt(String purchasedAt) {
        this.purchasedAt = purchasedAt;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
