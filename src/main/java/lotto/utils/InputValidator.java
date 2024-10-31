package lotto.utils;

public class InputValidator {
    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }

    public static void validateNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 값을 입력할 수 없습니다.");
        }
    }
}
