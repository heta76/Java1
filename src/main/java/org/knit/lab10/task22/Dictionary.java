package org.knit.lab10.task22;

import org.knit.lab10.task18.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary<K, V> {
    private final List<Pair<K, V>> list;

    // Конструктор
    public Dictionary() {
        this.list = new ArrayList<>();
    }

    // Метод для добавления элемента
    public void put(K key, V value) {
        list.add(new Pair<>(key, value));
    }

    // проверка вхождения элемента в список
    private boolean containsKey(K key){
        return list.stream().anyMatch(person -> person.getFirst().equals(key));
    }
    // Метод для получения элемента по ключу
    public Pair<K, V> get(K key) {
        if (containsKey(key)){
            return list.stream().filter(person -> person.getFirst().equals(key)).findFirst().get();
        }
        System.out.println("Элемента с таким ключом нет");
        return null;
    }

    // Метод для удаления элемента по ключу
    public void remove(K key) {
        if (containsKey(key)){
            System.out.println(get(key));
            list.remove(get(key));
        }
        else {
            System.out.println("Элемента стаким ключом нет");
        }
    }

//    // Метод для проверки наличия ключа
//    public boolean containsKey(K key) {
//        return list.containsKey(key);
//    }
//
//    // Метод для получения всех ключей
//    public Iterable<K> keys() {
//        return list.;
//    }

    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();

        // Добавление элементов
        dictionary.put("Alice", 25);// true

        dictionary.put("Bob", 30);

        // Получение элемента
        System.out.println(dictionary.get("Alice")); // 25
        System.out.println(dictionary.containsKey("Alice")); // true


        // Удаление элемента
        dictionary.remove("Alice");
        System.out.println(dictionary.get("Alice")); // null

        // Проверка ключа
        System.out.println(dictionary.containsKey("Bob")); // true



    }
}
