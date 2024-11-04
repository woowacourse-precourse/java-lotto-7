package lotto.util;

public class Parser {
    private Parser() {}

    public static int stringToInt(String input) {
        return Integer.parseInt(input.trim());
    }

    public static String[] stringToArray(String input) {
        return input.trim().split(",");
    }
}
