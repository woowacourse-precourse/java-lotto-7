package lotto.utils;

import lotto.constants.errorType.LottoPurchaseErrorType;

public class LottoPurchaseValidation {

    public static int validateMoneyIsInteger(String rawClientInput) {
        try {
            return Integer.parseInt(rawClientInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_MONEY_FORMAT.getMessage());
        }
    }

    public static void validateMoneyIsPositive(int rawIntegerInput) {
        if (rawIntegerInput < 0) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_MONEY_NEGATIVE.getMessage());
        }
    }

    public static void validateMoneyIsNotDivisibleByLottoPrice(int rawIntegerInput) {
        if (rawIntegerInput % 1000 != 0) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_MONEY_UNIT.getMessage());
        }
    }

    public static void validateMoneyIsNull(String rawClientInput) {
        if (rawClientInput.isBlank()) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_INPUT_NULL_MONEY.getMessage());
        }
    }

}
