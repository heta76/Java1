package org.knit.lab10.task21;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterUtils {

    // Универсальный метод filter
    public static <T> List<T> filter(List<T> items, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Пример использования
        List<String> words = List.of("apple", "banana", "cherry");
        List<String> filtered = filter(words, s -> s.startsWith("b"));
        System.out.println(filtered); // [banana]

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = filter(numbers, n -> n % 2 == 0);
        System.out.println(evenNumbers); // [2, 4, 6]
    }
}
