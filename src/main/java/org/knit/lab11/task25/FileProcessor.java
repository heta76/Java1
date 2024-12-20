package org.knit.lab11.task25;

import org.knit.lab11.task24.UserDAO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Objects;

public class FileProcessor {
    private FileDAO fileDAO;

    public FileProcessor(FileDAO fileDAO) {
        this.fileDAO = fileDAO;
    }

    public void processFiles(String unreadyPath) {
        Path readyPath = Paths.get(unreadyPath);
        try {
            if (Files.isDirectory(readyPath)) {
                for (var file : Objects.requireNonNull(new File(unreadyPath).listFiles())) {
                    if (file.length() < 10_485_760) {
                        fileDAO.saveFile(file);
                    } else {
                        System.out.println("Размер файла" + file.getName() + "больше 10мб");
                    }
                }
            } else if (Files.isRegularFile(readyPath)) {
                File file = new File(unreadyPath);
                if (file.length() < 10_485_760) {
                    fileDAO.saveFile(file);
                } else {
                    System.out.println("Размер файла" + file.getName() + "больше 10мб");
                }
            } else {
                System.out.println("Неверный путь.");
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
