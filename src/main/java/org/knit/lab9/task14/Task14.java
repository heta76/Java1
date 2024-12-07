package org.knit.lab9.task14;

import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите текущий сигнал светофора (RED, YELLOW, GREEN): ");
        System.out.println("Следующий сигнал: " + TrafficLight.valueOf(in.nextLine().toUpperCase()).getNextLight());
    }
}
