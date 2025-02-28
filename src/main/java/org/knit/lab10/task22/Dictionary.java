package org.knit.lab10.task22;

import org.knit.lab10.task18.Pair;

import java.util.ArrayList;
import java.util.List;

public class Dictionary<K, V> {
    private final List<Pair<K, V>> list;

    public int getLength(){
        return list.size();
    }

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
            System.out.println("Значение по ключу " + key + " удалено" );
        }
        else {
            System.out.println("Элемента стаким ключом нет");
        }
    }

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
        dictionary.get("Alice"); // элемента теперь нет

        // Проверка ключа
        System.out.println(dictionary.containsKey("Bob")); // true
        System.out.println(dictionary.getLength());
    }
}
