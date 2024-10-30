package lotto.validator;

import lotto.exception.ErrorMessage;

public class LottoValidator {
    private static final int LOTTO_PRICE = 1000;

    public static void validateLottoPurchaseAmount(int price) {
        if (price % LOTTO_PRICE > 0 || price / LOTTO_PRICE < 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_DIVISIBLE_BY_LOTTO_PRICE.getMessage());
        }
    }
}
