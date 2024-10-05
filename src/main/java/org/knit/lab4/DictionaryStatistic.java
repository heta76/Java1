package org.knit.lab4;

import java.util.Arrays;

public class DictionaryStatistic {
    private String[] words;
    private int dictionarySize; // Количество слов
    private int polindrom; // Количество слов полиндромов
    private int maxWordLength; // маскимальная длина слова в словаре
    private int minWordLength = 100; // минимальная длина слова в словаре
    private char[] alphabet; // буквы алфавита
    private int[] frequency; //частота букв в словаре (в кадой ячейке хранит частоту букв, а индрес - это позиция буквы в alpabet)

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
        dictionarySize = words.length;
    }

    public int getDictionarySize() {
        return dictionarySize;
    }

    public void findAll() {
        for (int i = 0; i < dictionarySize; i++) {
            maxWordLength = Math.max(words[i].length(), maxWordLength);
            minWordLength = Math.min(words[i].length(), minWordLength);
            char[] letters = words[i].toCharArray();
            frequency = new int[alphabet.length];
            for (int j = 0; j < letters.length; j++) {
                frequency[letters[j]] += 1;
            }
            if (words[i].equals(new StringBuilder(words[i]).reverse().toString())) {
                polindrom += 1;
            }
        }
        System.out.println(polindrom);
//        System.out.println(frequency.length);
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }

    public int getMinWordLength() {
        return minWordLength;
    }

    public int[] getFrequency() {
        return frequency;
    }

    // получить случайное слово из словаря
    public String getRandomWord() {
        /*
                реализация
        */
        return null;
    }

    public void printSymbolsStat() {


    }
}
