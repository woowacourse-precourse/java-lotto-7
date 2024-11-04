package lotto.validator;

import static lotto.exception.Exception.*;

public class LottoAmountValidator {
    public static void validate(int purchaseAmount, int lottoPrice) {
        validatePositiveAmount(purchaseAmount);
        validateDivisibleByLottoPrice(purchaseAmount, lottoPrice);
    }

    private static void validatePositiveAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_MUST_BE_POSITIVE.getMessage());
        }
    }

    private static void validateDivisibleByLottoPrice(int purchaseAmount, int lottoPrice) {
        if (purchaseAmount % lottoPrice != 0) {
            throw new IllegalArgumentException(ONLY_DIVISIBLE_BY_LOTTO_PRICE.getMessage());
        }
    }
}
