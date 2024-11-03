package lotto.utils;

public class PurchaseValidator {

    public static void validateAmount(String input) {
        validateNotBlank(input);
        validateIsNumeric(input);
        validateMultipleOfThousand(input);
        validateNotZero(input);
        validatePositiveAmount(input);
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 공백일 수 없습니다.");
        }
    }

    private static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("금액은 숫자여야 합니다.");
        }
    }

    private static void validateMultipleOfThousand(String input) {
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
    }

    private static void validateNotZero(String input) {
        if (Integer.parseInt(input) == 0) {
            throw new IllegalArgumentException("금액은 0일 수 없습니다.");
        }
    }

    private static void validatePositiveAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 0보다 커야 합니다.");
        }
    }

}
