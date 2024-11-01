package lotto.model;

import static lotto.common.LottoRule.LOTTO_PRICE;
import static lotto.validator.ValidationMessage.INVALID_NEGATIVE_PRICE;
import static lotto.validator.ValidationMessage.INVALID_PURCHASE_PRICE;

import lotto.exception.InvalidInputException;

public record LottoPurchasePrice(int price) {

    private static final int REMAINDER = 0;

    public LottoPurchasePrice {
        validPurchasePrice(price);
        validDivisibleByLottoPrice(price);
    }

    private void validPurchasePrice(int price) {
        if (price <= 0) {
            throw new InvalidInputException(INVALID_NEGATIVE_PRICE.getMessage());
        }
    }

    private void validDivisibleByLottoPrice(int price) {
        if (price % LOTTO_PRICE.getValue() != REMAINDER) {
            throw new InvalidInputException(INVALID_PURCHASE_PRICE.getMessage());
        }
    }
}
