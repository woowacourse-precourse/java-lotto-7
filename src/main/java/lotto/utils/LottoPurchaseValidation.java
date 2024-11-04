package lotto.utils;

import lotto.constants.errorType.LottoPurchaseErrorType;
import lotto.constants.lottoType.LottoType;

public class LottoPurchaseValidation {

    public static int checkedClientMoney(String rawClientMoney) {
        validateMoneyIsNull(rawClientMoney);
        int clientMoney = validateMoneyIsInteger(rawClientMoney);
        validateMoneyIsPositive(clientMoney);
        validateMoneyIsNotDivisibleByLottoPrice(clientMoney);
        return clientMoney;
    }

    public static int validateMoneyIsInteger(String rawClientInput) {
        try {
            return Integer.parseInt(rawClientInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_MONEY_FORMAT.getMessage());
        }
    }

    public static void validateMoneyIsPositive(int rawIntegerInput) {
        if (rawIntegerInput < LottoType.ZERO_MONEY.getValue()) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_MONEY_NEGATIVE.getMessage());
        }
    }

    public static void validateMoneyIsNotDivisibleByLottoPrice(int rawIntegerInput) {
        if (rawIntegerInput % LottoType.LOTTO_PRICE.getValue() != LottoType.ZERO_MONEY.getValue()) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_MONEY_UNIT.getMessage());
        }
    }

    public static void validateMoneyIsNull(String rawClientInput) {
        if (rawClientInput.isBlank()) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_INPUT_NULL_MONEY.getMessage());
        }
    }

}
