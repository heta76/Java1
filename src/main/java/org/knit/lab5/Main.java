package org.knit.lab5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] names = {"книга", "ручка", "линейка", "пенал"};
        Random random = new Random();
        Comparator<ShopItem> comparator = Comparator.comparing(ShopItem::getPrice).thenComparing(ShopItem::getArticule);
        ShopItem[] items = new ShopItem[100];
        int count = 0;
        for (int i = 0; i < 100; i++) {
            int index = random.nextInt(4);
            items[i] = new ShopItem(names[index]);
        }
        for (int i = 0; i < items.length - 1; i++) {
            for (int j = 1; j < items.length; j++){
                if (items[i].equals(items[j])){
                    count+=1;
                }
            }
        }
        Arrays.sort(items, comparator);
        for (ShopItem product : items) {
            System.out.println(product);
        }
        System.out.println(count);
    }
}
