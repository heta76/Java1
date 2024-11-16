package org.knit.lab7.task12;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class TextFileProcessor implements FileVisitor<Path> {

    private int totalWordsCount;

    public TextFileProcessor() {
        totalWordsCount = 0;
    }
    public int getTotalWordsCount() {
        return totalWordsCount;
    }
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".txt")) {
            try (BufferedReader reader = Files.newBufferedReader(file)) {
                String line;
                long wordCount = 0;
                while ((line = reader.readLine()) != null) {
                    // Разбиваем строку на слова, используя пробелы и другие разделители
                    String[] words = line.split("\\s+");
                    wordCount += words.length;
                }
                System.out.println("Cлов в файле " + file + ": " + wordCount);
                totalWordsCount += wordCount;
            }
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
