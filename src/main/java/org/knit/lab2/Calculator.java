package org.knit.lab2;

import java.util.Scanner;

/**
 * *Задача № 3: Реализация консольного калькулятора**
 * <p>
 * Необходимо создать консольное приложение-калькулятор, которое может выполнять основные арифметические операции (сложение, вычитание, умножение, деление) над двумя числами.
 * ### Условие:
 * 1. Создайте класс `Calculator`, который будет содержать методы для выполнения следующих арифметических операций:
 * - `add(double a, double b)` — сложение.
 * - `subtract(double a, double b)` — вычитание.
 * - `multiply(double a, double b)` — умножение.
 * - `divide(double a, double b)` — деление (проверьте деление на ноль и выбросите исключение с соответствующим сообщением).
 * <p>
 * 2. В главном классе программы создайте метод `main`, который:
 * - Считывает два числа (целые или вещественные) с консоли.
 * - Считывает оператор (`+`, `-`, `*`, `/`) с консоли.
 * - Выполняет соответствующую операцию, используя методы класса `Calculator`, и выводит результат на экран.
 * <p>
 * 3. Добавьте проверку деления на ноль и вывод сообщения об ошибке, если пользователь пытается разделить на ноль.
 * <p>
 * 4. Программа должна продолжать работать до тех пор, пока пользователь не введет команду выхода (например, `exit`).
 * <p>
 * ### Пример использования:
 * <p>
 * Введите первое число: 5
 * Введите оператор (+, -, *, /): *
 * Введите второе число: 3
 * Результат: 15.0
 * <p>
 * Введите первое число: 10
 * Введите оператор (+, -, *, /): /
 * Введите второе число: 0
 * Ошибка: Деление на ноль невозможно.
 * <p>
 * Введите первое число: exit
 * Выход из программы.
 * <p>
 * ### Ожидаемое поведение:
 * 1. Программа принимает два числа и оператор, затем выводит результат вычислений.
 * 2. Программа корректно обрабатывает ошибки, такие как деление на ноль.
 * 3. При вводе команды `exit`, программа завершает свою работу.
 * <p>
 * ### Цель задачи:
 * Практиковаться в работе с простыми типами данных (числами), операторами и условными конструкциями.  Научиться обрабатывать исключения и работать с консольным вводом и выводом.
 */

public class Calculator {
    public static void main(String[] args) {
        while (true) {
            Scanner console = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            String firstNumber = console.nextLine();
            if (firstNumber.equals("exit") ){
                System.out.println("Выход из программы.");
                break;
            }
            System.out.print("Введите оператор (+, -, *, /): ");
            String operation = console.nextLine();
            if (operation.equals("exit") ){
                System.out.println("Выход из программы.");
                break;
            }
            System.out.print("Введите второе число: ");
            String secondNumber = console.nextLine();
            if (secondNumber.equals("exit") ){
                System.out.println("Выход из программы.");
                break;
            }
            toDo(firstNumber, secondNumber, operation);
        }
    }

    public static void toDo(String firstNumber, String secondNumber, String operation) {
        switch (operation) {
            case ("+"):
                System.out.println(add(Double.valueOf(firstNumber), Double.valueOf(secondNumber)));
                break;
            case ("-"):
                System.out.println(subtract(Double.valueOf(firstNumber), Double.valueOf(secondNumber)));
                break;
            case ("*"):
                System.out.println(multiply(Double.valueOf(firstNumber), Double.valueOf(secondNumber)));
                break;
            case ("/"):
                System.out.println(divide(Double.valueOf(firstNumber), Double.valueOf(secondNumber)));
                break;
            default:
                break;
        }
    }


    public static String add(double firstNumber, double secondNumber) {
        double result;
        result = firstNumber + secondNumber;
        String strNumber = String.valueOf(result);
        return "Результат: " + strNumber;
    }

    public static String subtract(double firstNumber, double secondNumber) {
        double result;
        result = firstNumber - secondNumber;
        String strNumber = String.valueOf(result);
        return "Результат: " + strNumber;
    }

    public static String multiply(double firstNumber, double secondNumber) {
        double result;
        result = firstNumber * secondNumber;
        String strNumber = String.valueOf(result);
        return "Результат: " + strNumber;
    }

    public static String divide(double firstNumber, double secondNumber) {
        double result;
        if (secondNumber == 0) {
            return "Ошибка: Деление на ноль невозможно.";
        }
        result = firstNumber / secondNumber;
        String strNumber = String.valueOf(result);
        return strNumber;
    }
}
