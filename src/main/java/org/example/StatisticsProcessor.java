package org.example;

import java.util.List;

public class StatisticsProcessor {

    public void process(LineStorage storage) {
        processIntegers(storage.getIntegers());
        processFloats(storage.getFloats());
        processStrings(storage.getStrings());
    }

    private void processIntegers(List<String> integers) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long sum = 0;

        for (String s : integers) {
            long value = Long.parseLong(s);
            if (value < min) min = value;
            if (value > max) max = value;
            sum += value;
        }

        double avg = sum / (double) integers.size();

        System.out.println("Integers Statistics:");
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Sum: " + sum);
        System.out.println("Avg: " + avg);
        System.out.println();
    }

    private void processFloats(List<String> floats) {
        double min = Double.MAX_VALUE;
        double max = -Double.MAX_VALUE;
        double sum = 0;

        for (String s : floats) {
            double value = Double.parseDouble(s);
            if (value < min) min = value;
            if (value > max) max = value;
            sum += value;
        }

        double avg = sum / floats.size();

        System.out.println("Floats Statistics:");
        System.out.println("Count: " + floats.size());
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Sum: " + sum);
        System.out.println("Avg: " + avg);
        System.out.println();
    }

    private void processStrings(List<String> strings) {
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        String minString = null;
        String maxString = null;

        for (String s : strings) {
            int len = s.length();
            if (len < minLength) {
                minLength = len;
                minString = s;
            }
            if (len > maxLength) {
                maxLength = len;
                maxString = s;
            }
        }

        System.out.println("Strings Statistics:");
        System.out.println("Min Length: " + minLength + ", String: \"" + minString + "\"");
        System.out.println("Max Length: " + maxLength + ", String: \"" + maxString + "\"");
    }
}
