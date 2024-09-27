package org.knit.lab2;

/**
 * Задача № 4: Реализация классов для объемных фигур и контейнера
 * <p>
 * Создайте класс Container, который будет иметь определённый объём, заданный при создании объекта. Контейнер должен хранить объемные фигуры и проверять, есть ли место для добавления новой фигуры.
 * <p>
 * Создайте класс Shape, который будет представлять абстрактную объемную фигуру. Определите метод getVolume(), который должен возвращать объем фигуры.
 * <p>
 * Создайте несколько классов-наследников от Shape, таких как Sphere (сфера), Cube (куб), Cylinder (цилиндр), каждая из которых должна реализовывать метод getVolume() для вычисления объема фигуры. Формулы для объема:
 * <p>
 * Сфера: ( V = \frac{4}{3} \pi r^3 )
 * Куб: ( V = a^3 )
 * Цилиндр: ( V = \pi r^2 h )
 * Добавьте в класс Container метод add(Shape shape), который будет принимать объект класса Shape. Метод должен проверять, можно ли добавить новую фигуру в контейнер с учётом её объёма:
 * <p>
 * Если объём фигуры меньше или равен оставшемуся свободному месту в контейнере, добавьте фигуру и уменьшите свободный объём контейнера.
 * Если объема не хватает, верните сообщение, что фигуру невозможно добавить.
 * Пример использования:
 * Container container = new Container(1000);  // Создаем контейнер с объемом 1000
 * <p>
 * Shape sphere = new Sphere(5);   // Создаем сферу с радиусом 5
 * Shape cube = new Cube(3);       // Создаем куб со стороной 3
 * <p>
 * container.add(sphere);  // Проверяем, можно ли добавить сферу
 * container.add(cube);    // Проверяем, можно ли добавить куб
 * Цель задачи: Практиковаться в использовании наследования, полиморфизма, работе с абстрактными классами, а также в реализации логики проверки состояния объектов (контейнера).
 */


public class Container {
    double volume;

    public Container(double volume) {
        this.volume = volume;
    }

    public static void main(String[] args) {
        Container container = new Container(1000);
        Shape sphere = new Sphere(6);
        Shape cube = new Cube(3);
        Shape cylinder = new Cylinder(3, 5);
        System.out.println(container.add(sphere));
        System.out.println(container.add(cube));
        System.out.println(container.add(cylinder));
    }

    public String add(Shape figure) {
        if (volume - figure.getVolume() >= 0) {
            volume = volume - figure.getVolume();
            return Double.toString(volume);
        }
        return "фигуру невозможно добавить";
    }
}


