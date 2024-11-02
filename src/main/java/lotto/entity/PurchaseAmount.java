package lotto.entity;

import static lotto.constant.Constant.THOUSAND;

import lotto.constant.ExceptionMessage;

public record PurchaseAmount(Long purchaseAmount) {

    public PurchaseAmount {
        validateNegative(purchaseAmount);
        validateNonThousandDivisibility(purchaseAmount);
    }

    private void validateNegative(Long number) {
        if (number < 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_NOT_NEGATIVE);
        }
    }

    private void validateNonThousandDivisibility(Long number) {
        if (number % THOUSAND != 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_THOUSAND_DIVISIBILITY);
        }
    }
}
