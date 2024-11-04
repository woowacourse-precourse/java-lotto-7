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

    public static int validateMoneyIsInteger(String rawClientMoney) {
        try {
            return Integer.parseInt(rawClientMoney.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_MONEY_FORMAT.getMessage());
        }
    }

    public static void validateMoneyIsPositive(int clientMoney) {
        if (clientMoney < LottoType.ZERO_MONEY.getValue()) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_MONEY_NEGATIVE.getMessage());
        }
    }

    public static void validateMoneyIsNotDivisibleByLottoPrice(int clientMoney) {
        if (clientMoney % LottoType.LOTTO_PRICE.getValue() != LottoType.ZERO_MONEY.getValue()) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_MONEY_UNIT.getMessage());
        }
    }

    public static void validateMoneyIsNull(String rawClientMoney) {
        if (rawClientMoney.isBlank()) {
            throw new IllegalArgumentException(LottoPurchaseErrorType.INVALID_INPUT_NULL_MONEY.getMessage());
        }
    }

}
