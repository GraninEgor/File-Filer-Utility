package org.example;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

    public static List<String> getOptions(String[] args){
        List<String> options = new ArrayList<>();

        for (String arg: args){
            if (arg.startsWith("-")){
                options.add(arg);
            }
        }
        return options;
    }
}
