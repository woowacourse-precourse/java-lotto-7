package lotto.model;

import static lotto.common.LottoRule.LOTTO_PRICE;
import static lotto.validator.ValidationMessage.INVALID_NEGATIVE_PRICE;
import static lotto.validator.ValidationMessage.INVALID_PURCHASE_PRICE;

import lotto.exception.InvalidInputException;

public record LottoPurchasePrice(int price) {
    private static final int REMAINDER = 0;
    private static final int NON_NEGATIVE_THRESHOLD = 0;

    public LottoPurchasePrice {
        validateNonNegativePrice(price);
        validateDivisibilityByLottoPrice(price);
    }

    private void validateNonNegativePrice(int price) {
        if (price <= NON_NEGATIVE_THRESHOLD) {
            throw new InvalidInputException(INVALID_NEGATIVE_PRICE.getMessage());
        }
    }

    private void validateDivisibilityByLottoPrice(int price) {
        if (price % LOTTO_PRICE.getValue() != REMAINDER) {
            throw new InvalidInputException(INVALID_PURCHASE_PRICE.getMessage());
        }
    }
}
