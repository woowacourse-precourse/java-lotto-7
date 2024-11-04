package lotto.util;

public class Splitter {
    public static final String DELIMITER = ",";

    private Splitter(){
    }

    public static String[] split(final String input) {
        return input.split(DELIMITER);
    }
}