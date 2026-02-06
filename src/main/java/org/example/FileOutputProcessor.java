package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
        try {
            Path dir = Path.of("out");
            Files.createDirectories(dir);

            writeFile(dir.resolve(buildPath("integers.txt")), lineStorage.getIntegers());
            writeFile(dir.resolve(buildPath("floats.txt")), lineStorage.getFloats());
            writeFile(dir.resolve(buildPath("strings.txt")), lineStorage.getStrings());

            printShortStatistics(lineStorage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String buildPath(String name){
        if (options.getPath() == ""){
            return options.getPrefix() + name;
        }
        return options.getPath() + "/" + options.getPrefix() + name;
    }

    private void printShortStatistics(LineStorage lineStorage){
        System.out.println("Целых чисел: " + lineStorage.getIntegers().size());
        System.out.println("Вещественныx чисел: " + lineStorage.getFloats().size());
        System.out.println("Строк: " + lineStorage.getStrings().size());
    }

    private void writeFile(Path path, List<String> lines) {
        StandardOpenOption mode = options.isInCurrentFilesMode()
                ? StandardOpenOption.APPEND
                : StandardOpenOption.TRUNCATE_EXISTING;

        try {
            Files.write(path, lines, StandardOpenOption.CREATE, mode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
