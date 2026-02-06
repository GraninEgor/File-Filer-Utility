package org.example;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileOutputProcessor {

    private final Options options;

    public FileOutputProcessor(Options options) {
        this.options = options;
    }

    public void save(LineStorage lineStorage) {
        Path baseDir = Path.of("out");

        String relativePath = options.path();

        if (relativePath.startsWith("/")) {
            relativePath = relativePath.substring(1);
        }

        relativePath = relativePath.replace("/", FileSystems.getDefault().getSeparator());

        Path targetDir = options.path().isEmpty()
                ? baseDir
                : baseDir.resolve(relativePath);

        try {
            Files.createDirectories(targetDir);
        } catch (IOException e) {
            System.out.println("Error creating output directory");
            return;
        }

        try {
            if (!lineStorage.getIntegers().isEmpty()){
                writeFile(targetDir.resolve(buildPath("integers.txt")), lineStorage.getIntegers());
            }
        } catch (IOException e) {
            System.out.println("Error saving integers.txt");
        }

        try {
            if (!lineStorage.getFloats().isEmpty()){
                writeFile(targetDir.resolve(buildPath("floats.txt")), lineStorage.getFloats());
            }
        } catch (IOException e) {
            System.out.println("Error saving floats.txt");
        }

        try {
            if (!lineStorage.getStrings().isEmpty()){
                writeFile(targetDir.resolve(buildPath("strings.txt")), lineStorage.getStrings());
            }
        } catch (IOException e) {
            System.out.println("Error saving strings.txt");
        }

        printShortStatistics(lineStorage);
    }

    private String buildPath(String name){
        return options.prefix() + name;
    }

    private void printShortStatistics(LineStorage lineStorage){
        System.out.println("Целых чисел: " + lineStorage.getIntegers().size());
        System.out.println("Вещественных чисел: " + lineStorage.getFloats().size());
        System.out.println("Строк: " + lineStorage.getStrings().size());
        System.out.println();
    }

    private void writeFile(Path path, List<String> lines) throws IOException {
        StandardOpenOption mode = options.inCurrentFilesMode()
                ? StandardOpenOption.APPEND
                : StandardOpenOption.TRUNCATE_EXISTING;

        Files.write(path, lines, StandardOpenOption.CREATE, mode);
    }
}
