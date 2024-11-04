package lotto.utils;

public class InputValidator {

    public static void validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }
    }
}
