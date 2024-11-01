package lotto.util;

public class StringValidator {

    private StringValidator() {
    }

    public static void validateNotBlank(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("문자열은 null이거나 공백일 수 없습니다.");
        }
    }

}
