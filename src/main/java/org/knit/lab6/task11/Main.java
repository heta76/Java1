package org.knit.lab6.task11;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet students = new TreeSet();
        System.out.println("Меню:\n 1. Добавить студента\n 2. Удалить студента\n 3. Показать всех студентов\n " +
                "4. Найти студента\n 5. Найти студентов по диапазону\n 6. Выйти");
        Scanner in = new Scanner(System.in);
        int option = 0;
        String newStudent;
        while (option != 6) {
            System.out.print("Выберите опцию:");
            option = Integer.parseInt(in.nextLine());
            switch (option) {
                case 1:
                    System.out.print("Введите имя студента:");
                    newStudent = in.nextLine();
                    students.add(newStudent);
                    System.out.println("Студент добавлен.");
                    break;
                case 2:
                    System.out.print("Введите имя студента для удаления:");
                    newStudent = in.nextLine();
                    if (students.remove(newStudent)) {
                        System.out.println("Студент удален.");
                    }
                    break;
                case 3:
                    System.out.println("Список студентов");
                    for (Object student : students) {
                        System.out.println(student);
                    }
                    break;
                case 4:
                    System.out.print("Введите имя студента для поиска:");
                    newStudent = in.nextLine();
                    if ((students.contains(newStudent))) {
                        System.out.println("Студент найден.");
                    } else {
                        System.out.println("Студент не найден.");
                    }
                    break;
                case 5:
                    System.out.print("Введите первого студента из списка: ");
                    String first = in.nextLine();
                    System.out.print("Введите второго студента из списка: ");
                    String last = in.nextLine();
                    System.out.println(String.join(" \n", students.subSet(first,last)));
                    break;
            }
        }
        in.close();
    }
}
