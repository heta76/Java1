package org.knit.lab5;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] names = {"книга", "ручка", "линейка", "пенал"};
        Random random = new Random();
        Comparator<ShopItem> comparator = Comparator.comparing(ShopItem::getName).thenComparing(ShopItem::getArticule);
        ShopItem[] items = new ShopItem[100];
        HashMap<String, Integer> itemsCount = new HashMap<>();

        for (int i = 0; i < 100; i++) {

            int index = random.nextInt(4);
            items[i] = new ShopItem(names[index]);
        }
        /*
        Во внешнем цикле, если есть товар, то скипается и товар, и внутренний цикл.
        Если товара нет, то добавляется и проходит по внутреннему циклу.
         */
        for (int i = 0; i < items.length; i++) {
            if (itemsCount.containsKey(items[i].getName() + items[i].getArticule().toString())){
                continue;
            }
            itemsCount.put(items[i].getName() + items[i].getArticule().toString(), 1);
            for (int j = i + 1; j < items.length; j++) {
                if (items[i].equals(items[j])) {
                    System.out.println("боба");
                    itemsCount.put(items[i].getName() + items[i].getArticule().toString(), itemsCount.get(items[i].getName() + items[i].getArticule().toString()) + 1);
                }
            }
        }
        Arrays.sort(items, comparator);
        for (ShopItem product : items) {
            System.out.println(product);
        }
        for (Map.Entry<String, Integer> entry : itemsCount.entrySet()) {
            if (entry.getValue() > 1){
                System.out.println(entry);
            }
        }
    }
}

