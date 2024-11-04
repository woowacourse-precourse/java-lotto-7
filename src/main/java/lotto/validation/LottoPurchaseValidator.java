package lotto.validation;

import lotto.constatnt.ExceptionMessage;

public class LottoPurchaseValidator {

    public void validate(String input) {
        checkBlankInput(input);
        checkIsNumber(input);
        checkPositiveNumber(input);
        checkMultipleOfThousand(input);
        checkUpperLimit(input);
    }

    private void checkBlankInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_PRICE_BLANK_INPUT.getMessage());
        }
    }

    private void checkIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_PRICE_NOT_NUMBER.getMessage());
        }
    }

    private void checkPositiveNumber(String input) {
        int price = Integer.parseInt(input);
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_PRICE_NOT_POSITIVE_NUMBER.getMessage());
        }
    }

    private void checkMultipleOfThousand(String input) {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_PRICE_NOT_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }

    private void checkUpperLimit(String input) {
        int price = Integer.parseInt(input);
        if (price >= 100_000_000) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_PRICE_UPPER_LIMIT.getMessage());
        }
    }
}
