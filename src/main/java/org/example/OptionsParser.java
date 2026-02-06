package org.example;

public class OptionsParser {
    public static Options getOptions(String[] args){
        String path = "";
        String prefix = "";
        boolean inCurrentFilesMode = false;
        boolean fullStatisticsMode = false;

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            if (!arg.startsWith("-")) {
                continue;
            }

            switch (arg) {
                case "-o" -> {
                    path = args[++i];
                }

                case "-p" -> {
                    prefix = args[++i];
                }

                case "-a" -> inCurrentFilesMode = true;

                case "-f" -> fullStatisticsMode = true;
            }
        }
        return new Options(path,prefix,inCurrentFilesMode,fullStatisticsMode);
    }
}
