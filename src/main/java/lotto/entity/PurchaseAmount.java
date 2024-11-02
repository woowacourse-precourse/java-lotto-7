package lotto.entity;

import static lotto.constant.Policy.LOTTO_PRICE;

import lotto.constant.ExceptionMessage;

public record PurchaseAmount(Long purchaseAmount) {

    public PurchaseAmount {
        validateNegative(purchaseAmount);
        validateLottoPriceDivisibility(purchaseAmount);
    }

    private void validateNegative(Long number) {
        if (number < 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_NOT_NEGATIVE);
        }
    }

    private void validateLottoPriceDivisibility(Long number) {
        if (number % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_LOTTO_PRICE_DIVISIBILITY);
        }
    }
}
