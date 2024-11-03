package lotto.exception;

import static lotto.message.ErrorMessage.PURCHASE_AMOUNT_INVALID;

import lotto.message.ErrorMessage;

public class UserInputException {
    private static final int TICKET_PRICE = 1000;

    public static void validatePurchaseAmount(String input) {
        validateForWhitespace(input);
        validateNumericInput(input);
    }

    public static void validatePurchaseAmountValue(int amount) {
        if (amount < TICKET_PRICE || amount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_INVALID.getMessage());
        }
    }

    private static void validateForWhitespace(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMERIC.getMessage());
        }
    }

    public static void validateNumericInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMERIC.getMessage());
            }
        }
    }

}
