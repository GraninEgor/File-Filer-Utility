package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileProcessor {

    public LineStorage execute(List<String> files) {
        LineStorage lineStorage = new LineStorage();
        for (String fileName: files){
            try (var lines = Files.lines(Path.of(fileName))) {
                lines.forEach(line -> {
                    LineType type = LineTypeUtil.getLineType(line);
                    switch (type) {
                        case INTEGER -> lineStorage.getIntegers().add(line);
                        case FLOAT -> lineStorage.getFloats().add(line);
                        case STRING -> lineStorage.getStrings().add(line);
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
        return lineStorage;
    }
}
