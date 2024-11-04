package lotto.common.validator;

import static lotto.common.ExceptionMessage.ERROR_INVALID_PURCHASE_AMOUNT_UNIT;
import static lotto.common.ExceptionMessage.ERROR_MAXIMUM_PURCHASE_AMOUNT;
import static lotto.common.ExceptionMessage.ERROR_MINIMUM_PURCHASE_AMOUNT;

import lotto.common.LottoConfig;

public class IssuedLottoValidator {
    public static void validate(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount == 0) {
            throw new IllegalArgumentException(ERROR_MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if (isInvalidPurchaseAmount(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(ERROR_INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
        }
        if (lottoPurchaseAmount > LottoConfig.LOTTO_PURCHASE_LIMIT.getValue()) {
            throw new IllegalArgumentException(ERROR_MAXIMUM_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static boolean isInvalidPurchaseAmount(int lottoPurchaseAmount) {
        return lottoPurchaseAmount % LottoConfig.LOTTO_PRICE.getValue() != 0;
    }
}
