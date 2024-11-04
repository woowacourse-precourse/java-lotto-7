package lotto.util;

public class ValidationUtils {
    public static void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 비어 있습니다.");
        }
    }

    public static void validateIsNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 숫자여야 합니다.");
        }
    }

    public static void validatePositive(long value) {
        if (value <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 0보다 커야 합니다.");
        }
    }

    public static void validateThousandUnit(long value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 숫자여야 합니다.");
        }
    }
}
