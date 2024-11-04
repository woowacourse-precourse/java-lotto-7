package lotto;

public class InputValidator {
    public static void validateBlank(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력은 공백이 아닌 숫자여야 합니다.");
        }
    }
}
