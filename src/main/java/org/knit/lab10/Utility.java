package org.knit.lab10;

public class Utility {

    // Универсальный метод для вывода имени класса объекта
    public static <T> void printType(T obj) {
        if (obj != null) {
            System.out.println(obj.getClass());
        } else {
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        // Примеры использования
        printType(123); // java.lang.Integer
        printType("Hello"); // java.lang.String
        printType(3.14); // java.lang.Double
        printType(null); // null
    }
}
