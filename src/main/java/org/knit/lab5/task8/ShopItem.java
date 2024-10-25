package org.knit.lab5.task8;

import java.util.Objects;
import java.util.Random;

public class ShopItem {
    private int price;
    private String name;
    private int articule;
    private int shop;
    Random random = new Random();


    public ShopItem(String name) {
        this.name = name;
        this.price = random.nextInt(10) + 5;
        this.articule = random.nextInt(20) + 1;
        this.shop = random.nextInt(5) + 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !obj.getClass().equals(this.getClass())) return false;
        ShopItem shopItem = (ShopItem) obj;  // Приведение типа
        return articule == shopItem.articule && name.equals(shopItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return name   + " № товара: " + articule + " цена: " + price
        + " № магазина: " + shop;
    }

    public Integer getArticule() {
        return articule;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
