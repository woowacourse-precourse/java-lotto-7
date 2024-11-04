package lotto;

public class InputValidator {
    public static void validateBlank(String value) {
        if (isBlank(value)) {
            throw new IllegalArgumentException("[ERROR] 입력은 공백이 아닌 숫자여야 합니다.");
        }
    }

    public static void validateWhitespace(String value) {
        if (hasWhitespace(value)) {
            throw new IllegalArgumentException("[ERROR] 입력은 공백이 포함되지 않은 입력이어야 합니다.");
        }
    }

    private static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    private static boolean hasWhitespace(String value) {
        return value.contains(" ");
    }
}
