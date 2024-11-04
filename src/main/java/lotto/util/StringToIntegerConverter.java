package lotto.util;

public class StringToIntegerConverter {
    private static final String ERROR_INVALID_NUMBER = "유효한 숫자를 입력해 주세요.";
    public static int convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER);
        }
    }
}
