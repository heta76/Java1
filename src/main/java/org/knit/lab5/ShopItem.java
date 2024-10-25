package org.knit.lab5;

import java.util.Objects;
import java.util.Random;
import java.util.Comparator;

public class ShopItem {
    private int price;
    private String name;
    private int articule;
    private int shop = 4;
    Random random = new Random();


    public ShopItem(String name) {
        this.name = name;
        this.price = random.nextInt(10);
        this.articule = random.nextInt(20);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ShopItem shopItem = (ShopItem) obj;  // Приведение типа
        return articule == shopItem.articule && name.equals(shopItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return name  + " цена: " + price  + " № товара: " + articule +
                " № магазина: " + shop;
    }

    public Integer getArticule() {
        return articule;
    }

    public Integer getPrice() {
        return price;
    }
}
