package lotto.utils;

import lotto.constants.errorType.LottoPurchaseErrorType;

public class LottoPurchaseValidation {

    public static int checkedClientMoney(String rawClientMoney) {
        validateMoneyIsNull(rawClientMoney);
        int clientMoney = validateMoneyIsInteger(rawClientMoney);
        validateMoneyIsPositive(clientMoney);
        validateMoneyIsNotDivisibleByLottoPrice(clientMoney);
        return clientMoney;
    }

    private static int validateMoneyIsInteger(String rawClientInput) {
        try {
            return Integer.parseInt(rawClientInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_MONEY_FORMAT.getMessage());
        }
    }

    private static void validateMoneyIsPositive(int rawIntegerInput) {
        if (rawIntegerInput < 0) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_MONEY_NEGATIVE.getMessage());
        }
    }

    private static void validateMoneyIsNotDivisibleByLottoPrice(int rawIntegerInput) {
        if (rawIntegerInput % 1000 != 0) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_MONEY_UNIT.getMessage());
        }
    }

    private static void validateMoneyIsNull(String rawClientInput) {
        if (rawClientInput.isBlank()) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_INPUT_NULL_MONEY.getMessage());
        }
    }

}
