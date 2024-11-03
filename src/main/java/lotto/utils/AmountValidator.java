package lotto.utils;

public class AmountValidator {
    private static void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 공백일 수 없습니다.");
        }
    }


}
