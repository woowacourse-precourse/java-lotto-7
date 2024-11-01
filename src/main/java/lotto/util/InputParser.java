package lotto.util;

public class InputParser {

    public static long parseLong(String input) {
        return Long.parseLong(input);
    }

    public static String getComma(long number) {
        return String.format("%,d", number);
    }
}
