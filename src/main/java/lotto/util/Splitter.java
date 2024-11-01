package lotto.util;

public class Splitter {
    public static final String DELIMITER = ",";

    public static String[] split(String input) {
        return input.split(DELIMITER);
    }
}
