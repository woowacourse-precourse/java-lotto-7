package lotto.util;

import lotto.message.ErrorMessage;

import java.util.Set;

public class ValidationUtils {

    public static void validateBuyAmount(String buyInput) {
        if (buyInput == null || buyInput.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_PURCHASE_AMOUNT.getMessage());
        }

        try {
            int buy = Integer.parseInt(buyInput);
            if (buy <= 0 || buy % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_PURCHASE_AMOUNT.getMessage(), e);
        }
    }

    public static void validateWinningNumbers(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }

        for (Integer num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
            }
        }
    }
}
