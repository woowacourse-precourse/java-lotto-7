package lotto.utils;

public class InputValidator {
    private static final String ERROR_ENTER_NULL_AND_EMPTY = "[ERROR] 공백은 입력할 수 없습니다.";

    public static void notNullAndEmpty(String raw) {
        if (raw == null || raw.isBlank()) {
            throw new IllegalArgumentException(ERROR_ENTER_NULL_AND_EMPTY);
        }
    }
}
