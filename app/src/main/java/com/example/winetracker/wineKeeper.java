package com.example.winetracker;

import java.io.Serializable;

public class wineKeeper implements Serializable {
    private String wineName;
    private String wineType;
    private String purchasedAt;
    private double price;
    private double rating;

    public wineKeeper(String wineName, String wineType, String purchasedAt, double price, double rating) {
        this.wineName = wineName;
        this.wineType = wineType;
        this.purchasedAt = purchasedAt;
        this.price = price;
        this.rating = rating;
    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public String getWineType() {
        return wineType;
    }

    public void setWineType(String wineType) {
        this.wineType = wineType;
    }

    public String getPurchasedAt() {
        return purchasedAt;
    }

    public void setPurchasedAt(String purchasedAt) {
        this.purchasedAt = purchasedAt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
