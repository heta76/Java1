package org.knit.lab5.task9;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//пример
public class Keyboard {

    public static void main(String[] args) throws FileNotFoundException {
        //получает текущее время в миллисекундах
        long timeMillis = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        List<String> dictWords = getWords();

        int words = 0;
        int rightWords = 0;
        int symbols = 0;
        List<String[]> mistakes = new ArrayList<>();
        while (true) {
            if (System.currentTimeMillis() - timeMillis >= 60000) {
                System.out.println("Минута вышла. Последнее введенное слово не учитывается!");
                break;
            } else {
                String randomWord = getRandomWord(dictWords);
                System.out.println("Введите: " + randomWord);
                String newWord = scanner.nextLine();

                if (System.currentTimeMillis() - timeMillis >= 60000) {
                    System.out.println("Минута вышла. Последнее введенное слово не учитывается!");
                    break;
                }

                words += 1;
                symbols += newWord.length();

                if (newWord.equals(randomWord)) {
                    rightWords += 1;
                } else {
                    mistakes.add(new String[] {randomWord, newWord});}
            }
        }
        System.out.println("Всего слов: " + words);
        System.out.println("Правильных слов: " + rightWords);
        System.out.println("Символов в секунду: " + symbols / 60.0);
        System.out.println("Символов введено: " + symbols);
        if (mistakes.isEmpty()){
            System.out.println("Ни одной ошибки. Молодец!");
        } else {
            System.out.println("Ваши ошибки\nСлово - Ваш Ввод");
            for (String[] pair : mistakes){
                System.out.println(pair[0] + " - " + pair[1]);
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
}
