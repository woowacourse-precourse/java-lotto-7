package lotto.utils;

public class Utils {
    private static final String POSITIVE_INTEGER_REGEX = "^[0-9]\\d*$";

    public static boolean isNumeric(String input) {
        return input.matches(POSITIVE_INTEGER_REGEX);
    }
}
