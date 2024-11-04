package lotto.application.util;

public class StringValidator {

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String NULL_STRING = ERROR_PREFIX + "문자열은 null일 수 없습니다.";
    public static final String BLANK_STRING = ERROR_PREFIX + "문자열은 공백일 수 없습니다.";


    private StringValidator() {
    }

    public static void validateNotBlank(String value) {
        if (value == null) {
            throw new IllegalArgumentException(NULL_STRING);
        }
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException(BLANK_STRING);
        }
    }
}
