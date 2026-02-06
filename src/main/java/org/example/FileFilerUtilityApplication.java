package org.example;

import java.util.List;

public class FileFilerUtilityApplication {
    public static void main(String[] args) {
        Options options = OptionsParser.getOptions(args);
        List<String> files = FileParser.getFileNames(args);

        FileProcessor fileProcessor = new FileProcessor();
        LineStorage storage = fileProcessor.execute(files);

        FileOutputProcessor fileOutputProcessor = new FileOutputProcessor(options);
        fileOutputProcessor.save(storage);

        if(options.fullStatisticsMode()){
            StatisticsProcessor statisticsProcessor = new StatisticsProcessor();
            statisticsProcessor.process(storage);
        }
    }
}