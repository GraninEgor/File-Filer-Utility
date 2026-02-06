package org.example;

import java.util.ArrayList;
import java.util.List;

public class FileParser {

    public static List<String> getFileNames(String[] args){
        List<String> fileNames = new ArrayList<>();

        for (String arg: args){
            if (!arg.startsWith("-")){
                fileNames.add(arg);
            }
        }
        return fileNames;
    }
}
