package org.knit.lab10.task20;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Number>{
    List<T> numbers = new ArrayList<>();

    public void add(T number) {
        numbers.add(number);
    }

    // Метод для вычисления суммы всех чисел в контейнере
    public double sum() {
        return numbers.stream()
                .mapToDouble(Number::doubleValue) // Преобразуем все числа в double
                .sum(); // Суммируем
    }

    public static void main(String[] args) {

        Box<Integer> integerBox = new Box<>();
        integerBox.add(10);
        integerBox.add(20);
        System.out.println(integerBox.sum()); // 30

        Box<Double> doubleBox = new Box<>();
        doubleBox.add(1.5);
        doubleBox.add(2.5);
        System.out.println(doubleBox.sum()); // 4.0
    }
}
