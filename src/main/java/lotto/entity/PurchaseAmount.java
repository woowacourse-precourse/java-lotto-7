package lotto.entity;

import static lotto.constant.Constant.THOUSAND;

import lotto.constant.ExceptionMessage;

public record PurchaseAmount(Long purchaseAmount) {

    public PurchaseAmount {
        validateNonThousandDivisibility(purchaseAmount);
    }

    private void validateNonThousandDivisibility(Long number) {
        if (number % THOUSAND != 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_THOUSAND_DIVISIBILITY);
        }
    }
}
