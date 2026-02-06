package org.example;

import java.util.ArrayList;
import java.util.List;

public class FileParser {

    public static List<String> getFileNames(String[] args){
        List<String> fileNames = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            if (arg.startsWith("-")) {
                if (arg.equals("-o") || arg.equals("-p")) {
                    i++;
                }
                continue;
            }

            fileNames.add(arg);
        }

        return fileNames;
    }
}
