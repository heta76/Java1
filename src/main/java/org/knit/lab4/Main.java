package org.knit.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int len = 67774;
        String alphabet = "";
        String[] words;
        Scanner scanner = new Scanner(new File("src\\files\\dictionary.txt"));
        words = new String[len];
        for (int i = 0; i < len; i++) {
            words[i] = scanner.nextLine();
        }
        scanner.close();
        for (int i = 'а'; i <= 'я'; i++) {
            alphabet += (char) i;
        }
        DictionaryStatistic dictionary = new DictionaryStatistic(words, alphabet.toCharArray());
        System.out.println(dictionary.getDictionarySize());
        System.out.println(dictionary.getPolindrom());
        System.out.println(dictionary.getMinWordLength());
        System.out.println(dictionary.getMaxWordLength());
        // частоты букв
        dictionary.printSymbolsStat();
        // случайное слово
        System.out.println(dictionary.getRandomWord());
        // игра
        dictionary.game("мыльница");
    }
}

