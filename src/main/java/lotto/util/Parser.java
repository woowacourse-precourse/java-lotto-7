package lotto.util;

public class Parser {
    private Parser() {}

    public static int stringParseToInt(String input) {
        return Integer.parseInt(input);
    }

    public static String[] stringParseToArray(String input) {
        return input.trim().split(",");
    }
}
