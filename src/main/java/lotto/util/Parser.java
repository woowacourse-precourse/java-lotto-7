package lotto.util;

public class Parser {

    private static final String DELIMITER = ",";

    public static int parseToInt(String input) {
        return Integer.parseInt(input);
    }

    public static String[] splitWithDelimiter(String input) {
        return input.split(DELIMITER);
    }
}
