package org.knit.lab2.task5;

public class Main {
    public static void main(String[] args) {
        // Создаем файлы
        FileSystemComponent file1 = new File("file1.txt", 100);
        FileSystemComponent file2 = new File("file2.txt", 200);
        FileSystemComponent file3 = new File("file3.txt", 300);
//        System.out.println(file1.getSize());
        // Создаем папки
        FileSystemComponent folder1 = new Folder("Folder1");
        FileSystemComponent folder2 = new Folder("Folder2");
        // Добавляем файлы в папки
        folder1.add(file1);
        folder1.add(file2);
        System.out.println(folder1.getSize());
    }
}
