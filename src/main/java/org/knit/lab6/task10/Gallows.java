package org.knit.lab6.task10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Gallows {
    public static void main(String[] args) throws FileNotFoundException {
        int mistakesCount = 6;
        Set<Character> foundLetters = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        // массив слов
        List<String> dictWords = getWords();
        String word = getRandomWord(dictWords);
        // массив слова
        List<Character> wordToGuess = new ArrayList<>();
        List<Character> guessedWord = new ArrayList<>();
        for (char c : word.toCharArray()) {
            wordToGuess.add(c);
            guessedWord.add('_');
        }
//        System.out.println(word);
        System.out.println("Загаданное слово: " + "_".repeat(word.length()));

        while (mistakesCount > 0) {
            System.out.print("Введите букву: ");
            char letter = stringToChar(scanner.nextLine());

            if (wordToGuess.contains(letter) && !foundLetters.contains(letter)) {
                System.out.print("Верно! Слово: ");
                foundLetters.add(letter);

                for (int i = 0; i < wordToGuess.size(); i++) {
                    if (wordToGuess.get(i).equals(letter)) {
                        System.out.print(wordToGuess.get(i));
                        guessedWord.set(i, letter);
                    } else {
                        if (foundLetters.contains(wordToGuess.get(i))) {
                            System.out.print(wordToGuess.get(i));
                        } else System.out.print('_');
                    }
                }
                System.out.println("");
//                System.out.println(foundLetters);
//                System.out.println(wordToGuess);
//                System.out.println(guessedWord);
                if (wordToGuess.equals(guessedWord)){
                    System.out.println("Вы победили!");
                    break;
                }
            } else {
                mistakesCount -= 1;
                System.out.println("Ошибка! Количество попыток: " + mistakesCount);
                if (mistakesCount == 0) {
                    System.out.println("Вы проиграли!");
                    System.out.println("Слово: " + word);
                }
            }
        }

    }

    //Возвращает список слов из файла
    public static List<String> getWords() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/files/dictionary.txt"));
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        scanner.close();
        return words;
    }

    // рандомное слово из списка
    private static String getRandomWord(List<String> words) {
        Random rnd = new Random();
        return words.get(rnd.nextInt(words.size()));
    }

    // проверка на букву
    public static char stringToChar(String input) {
        if (input.length() == 1) {
            return input.charAt(0);
        } else {
            throw new IllegalArgumentException("Строка должна содержать ровно одну букву.");
        }
    }
}
