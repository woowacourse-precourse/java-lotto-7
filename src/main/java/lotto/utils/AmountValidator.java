package lotto.utils;

public class AmountValidator {
    private static void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 공백일 수 없습니다.");
        }
    }

    private static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    private static void validateMultipleOfThousand(String input) {
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000의 배수여야 합니다.");
        }
    }


}
