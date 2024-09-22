package org.knit;

import org.knit.lab1.SimpleUrl;
import org.knit.lab1.Task1;
import org.knit.lab1.Task2;

public class Main {
    public static void main(String[] args) {
//        Task1 task1 = new Task1();
//        task1.execute();

        SimpleUrl simpleUrl = new SimpleUrl();
        simpleUrl.execute();
        System.out.println(simpleUrl.toString());
        simpleUrl.listContent();
    }
}
