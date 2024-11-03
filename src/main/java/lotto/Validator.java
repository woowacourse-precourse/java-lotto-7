package lotto;

public class Validator {

    private static final String NUMERIC_REGEX = "-?\\d+";

    public static boolean isNumeric(String str) {
        return str.matches(NUMERIC_REGEX);
    }

    public static boolean isDivided(int num, int divider) {
        return num % divider == 0;
    }
}
