package lotto.validator;

import static lotto.exception.Exception.*;

public class LottoAmountValidator {
    public static void validate(int purchaseAmount, int lottoPrice) {
        validatePositiveAmount(purchaseAmount);
    }

    private static void validatePositiveAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_MUST_BE_POSITIVE.getMessage());
        }
    }

}
