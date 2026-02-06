package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileOutputProcessor {

    public void save(LineStorage lineStorage, List<String> options){
        try {
            Path dir = Path.of("out");
            Files.createDirectories(dir);
            Files.write(dir.resolve("integers.txt"), lineStorage.getIntegers());
            Files.write(dir.resolve("floats.txt"),  lineStorage.getFloats());
            Files.write(dir.resolve("strings.txt"), lineStorage.getStrings());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
