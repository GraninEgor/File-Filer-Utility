package org.example;

public class LineTypeUtil {

    public static LineType getLineType(String line){
        if (isInt(line)) {
            return LineType.INTEGER;
        } else if (isFloat(line)) {
            return LineType.FLOAT;
        } else {
            return LineType.STRING;
        }
    }

    public static boolean isInt(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isFloat(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
