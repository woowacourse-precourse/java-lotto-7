package lotto.parser;

public class NumberParser {
    private static final String INPUT_IS_NOT_NUMBER = "[ERROR] 숫자를 입력해주세요.";
    private NumberParser() {}

    public static Long parseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

    public static Integer parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }
}
