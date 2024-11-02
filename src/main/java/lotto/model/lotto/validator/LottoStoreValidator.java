package lotto.model.lotto.validator;

import static lotto.exception.ErrorBase.PURCHASE_AMOUNT_INVALID;
import static lotto.exception.ErrorBase.PURCHASE_AMOUNT_NOT_MULTIPLE;
import static lotto.util.LottoConstants.LOTTO_PURCHASE_AMOUNT;

public class LottoStoreValidator {
    public static void validate(Long purchaseAmount) {
        validatePositiveAmount(purchaseAmount);
        validateAmountUnit(purchaseAmount);
    }

    private static void validatePositiveAmount(Long purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_INVALID.getMessage());
        }
    }

    private static void validateAmountUnit(Long purchaseAmount) {
        if (purchaseAmount % LOTTO_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_MULTIPLE.getMessage());
        }
    }
}
