package org.knit.lab2.task5;

/**
 * Задача № 5: Реализация файловой системы с использованием паттерна Компоновщик
 * <p>
 * Необходимо смоделировать простую файловую систему, в которой могут быть как отдельные файлы, так и папки, содержащие другие файлы и папки. Паттерн "Компоновщик" позволит работать с объектами файлов и папок единообразно.
 * <p>
 * Условие:
 * Создайте абстрактный класс или интерфейс FileSystemComponent, который будет представлять общий элемент файловой системы (файл или папку). В нем должны быть следующие методы:
 * <p>
 * getName(): возвращает имя элемента.
 * getSize(): возвращает размер элемента в байтах.
 * add(FileSystemComponent component): добавляет элемент в папку (опционально).
 * remove(FileSystemComponent component): удаляет элемент из папки (опционально).
 * display(String indent): выводит структуру файловой системы в удобном формате.
 * Создайте класс File, который наследует или реализует FileSystemComponent. Файл будет иметь имя и размер. Реализуйте методы getName() и getSize(), метод add() для файлов не должен быть реализован (файл не может содержать другие элементы).
 * <p>
 * Создайте класс Folder, который также наследует или реализует FileSystemComponent. Папка может содержать другие папки и файлы, и её размер равен сумме размеров всех файлов и папок внутри неё. Реализуйте методы getName(), getSize(), add(), remove() и display().
 * <p>
 * Реализуйте метод display(String indent) таким образом, чтобы он отображал структуру файлов и папок с соответствующими отступами для вложенных элементов.
 * <p>
 * Пример использования:
 * public class Main {
 * public static void main(String[] args) {
 * // Создаем файлы
 * FileSystemComponent file1 = new File("file1.txt", 100);
 * FileSystemComponent file2 = new File("file2.txt", 200);
 * FileSystemComponent file3 = new File("file3.txt", 300);
 * <p>
 * // Создаем папки
 * FileSystemComponent folder1 = new Folder("Folder1");
 * FileSystemComponent folder2 = new Folder("Folder2");
 * <p>
 * // Добавляем файлы в папки
 * folder1.add(file1);
 * folder1.add(file2);
 * <p>
 * folder2.add(file3);
 * folder2.add(folder1); // Вложенная папка
 * <p>
 * // Выводим структуру файловой системы
 * folder2.display("");
 * <p>
 * // Выводим общий размер папки 2
 * System.out.println("Total size of Folder2: " + folder2.getSize() + " bytes");
 * }
 * }
 * Ожидаемый вывод:
 * Folder2
 *  file3.txt (300 bytes)
 *  Folder1
 *      file1.txt (100 bytes)
 *      file2.txt (200 bytes)
 * <p>
 * Total size of Folder2: 600 bytes
 * Цель задачи:
 * Практиковаться в реализации паттерна Компоновщик (Composite) и применении его для работы с иерархическими структурами, такими как файловые системы. Научиться работать с общими интерфейсами для различных типов объектов (файлы и папки).
 */
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
        file3.add(file1);
        System.out.println(folder1.getSize());
    }
}
