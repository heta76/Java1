package org.knit.lab11.task25;

import org.knit.lab11.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class FileApp {

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            FileDAO fileDAO = new FileDAO(connection);
            FileProcessor fileProcessor = new FileProcessor(fileDAO);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите путь к файлу или папке: ");
            String path = scanner.nextLine();
            fileProcessor.processFiles(path);
        }
    }
}
