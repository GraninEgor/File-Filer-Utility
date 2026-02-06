package org.example;

import java.util.List;

public class FileFilerUtilityApplication {
    public static void main(String[] args) {
        List<String> options = OptionsParser.getOptions(args);
        List<String> files = FileParser.getFileNames(args);
        FileProcessor fileProcessor = new FileProcessor();
        LineStorage storage = fileProcessor.execute(files, options);
        FileOutputProcessor fileOutputProcessor = new FileOutputProcessor();
        fileOutputProcessor.save(storage, options);
    }
}