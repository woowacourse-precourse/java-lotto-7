package lotto.util;

public class RegexUtils {
    public static String removeSpaces(String str) {
        return str.replaceAll("\\s+", "");
    }

    public static Boolean isNumeric(String str) {
        return str.matches("^-?\\d+$");
    }

    public static Boolean isPositiveNumeric(String str) {
        return str.matches("\\d+$");
    }
}
