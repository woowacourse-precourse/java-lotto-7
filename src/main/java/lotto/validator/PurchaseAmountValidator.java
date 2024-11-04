package lotto.validator;

import static lotto.constants.ErrorMessages.*;

import lotto.constants.LottoConstants;

public class PurchaseAmountValidator {
    public static void validate(int amount) {
        if (amount < LottoConstants.LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_MINIMUM_AMOUNT);
        }
        if (amount % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_UNIT);
        }
    }
}
