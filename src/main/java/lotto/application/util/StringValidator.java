package lotto.application.util;

public class StringValidator {

    private StringValidator() {
    }

    public static void validateNotBlank(String value) {
        if (value == null) {
            throw new IllegalArgumentException("[ERROR] 문자열은 null일 수 없습니다.");
        }

        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 문자열은 공백일 수 없습니다.");
        }
    }

}
