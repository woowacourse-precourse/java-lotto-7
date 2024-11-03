package lotto.domain;

import lotto.util.enums.ValidateMessage;

public class Purchase {
    private final int priceAmount;

    public Purchase(int priceAmount) {
        validatePriceAmountThousandMultiple(priceAmount);
        validatePriceAmountUnderHundredThousand(priceAmount);
        this.priceAmount = priceAmount;
    }

    public int getPriceAmount() {
        return priceAmount;
    }

    private void validatePriceAmountThousandMultiple(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ValidateMessage.NOT_ONE_THOUSAND_MULTIPLE_ERROR.getMessage());
        }
    }

    private void validatePriceAmountUnderHundredThousand(int amount) {
        if (amount > 100000) {
            throw new IllegalArgumentException(ValidateMessage.NOT_PURCHASE_MORE_HUNDRED_THOUSAND.getMessage());
        }
    }
}
