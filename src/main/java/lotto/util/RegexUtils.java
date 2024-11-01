package lotto.util;

public class RegexUtils {
    static String removeSpaces(String str) {
        return str.replaceAll("\\s+", "");
    }

    static Boolean isPositiveNumeric(String str) {
        return str.matches("\\d+$");
    }
}
