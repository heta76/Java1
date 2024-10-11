package org.knit.lab4;

import java.util.Random;

public class DictionaryStatistic {
    private String[] words;
    private int dictionarySize; // Количество слов
    private int polindrom; // Количество слов полиндромов
    private int maxWordLength; // маскимальная длина слова в словаре
    private int minWordLength = 50; // минимальная длина слова в словаре
    private char[] alphabet; // буквы алфавита
    private int[] frequency; //частота букв в словаре (в кадой ячейке хранит частоту букв, а индрес - это позиция буквы в alpabet)

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
        this.dictionarySize = words.length;

        // Palindrome
        for (String word : words) {
            maxWordLength = Math.max(word.length(), maxWordLength);
            minWordLength = Math.min(word.length(), minWordLength);
            if (isPalindrom(word.toCharArray())) {
                polindrom += 1;
            }
        }
        findFrequency();
    }

    // поиск частоты букв
    private void findFrequency() {
        frequency = new int[alphabet.length];
        for (String word : words) {
            char[] letters = word.toCharArray();
            for (char letter : letters) {
                int index = findIndexOfLetterInAlphabet(alphabet, letter);
                if (index >= 0) {
                    frequency[index] += 1;
                }
            }
        }
    }

    // поиск индекса буквы
    private int findIndexOfLetterInAlphabet(char[] array, char charToFind) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == charToFind) {
                return i;
            }
        }
        return -1;
    }

    // проверка на палиндром
    private static boolean isPalindrom(char[] word) {
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }

    // получить случайное слово из словаря
    public String getRandomWord() {
        Random rnd = new Random();
        return words[rnd.nextInt(dictionarySize)];
    }

    // поиск количества вхождений буквы из проверяемого слова в исходное
    private int countLettersInCharArray(char[] array, char charToFind) {
        int result = 0;
        for (char c : array) {
            result += c == charToFind ? 1 : 0;
        }
        return result;
    }

    public void game(String originalWord) {
        for (String wordToCheck : words) {
            boolean isCorrect = true;

            if (wordToCheck.equals(originalWord) || wordToCheck.length() > originalWord.length())
                continue;

            for (char letterToCheck : wordToCheck.toCharArray()) {
                if ((countLettersInCharArray(originalWord.toCharArray(), letterToCheck)) == 0 ||
                        countLettersInCharArray(wordToCheck.toCharArray(), letterToCheck) > countLettersInCharArray(originalWord.toCharArray(), letterToCheck)) {
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect)
                System.out.println(wordToCheck);
        }
    }


    public void printSymbolsStat() {
        for (int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[i] + ": " + frequency[i]);
        }
    }

    // геттеры
    public int getDictionarySize() {
        return dictionarySize;
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

    public int getPolindrom() {
        return polindrom;
    }

    public char[] getAlphabet() {
        return alphabet;
    }

    public String[] getWords() {
        return words;
    }
}
