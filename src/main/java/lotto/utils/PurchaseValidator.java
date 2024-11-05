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
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.BLANK_INPUT.getMessage());
        }
    }

    private static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NON_NUMERIC.getMessage());
        }
    }

    private static void validateMultipleOfThousand(String input) {
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.NOT_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }

    private static void validateNotZero(String input) {
        if (Integer.parseInt(input) == 0) {
            throw new IllegalArgumentException(ErrorMessages.NOT_ZERO.getMessage());
        }
    }

    private static void validatePositiveAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessages.NEGATIVE_AMOUNT.getMessage());
        }
    }
}
