package lotto.domain;

import lotto.util.enums.ValidateMessage;

public class Purchase {
    private final int amount;

    public Purchase(int amount) {
        validateAmountThousandMultiple(amount);
        validateAmountUnderHundredThousand(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validateAmountThousandMultiple(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ValidateMessage.NOT_ONE_THOUSAND_MULTIPLE_ERROR.getMessage());
        }
    }

    private void validateAmountUnderHundredThousand(int amount) {
        if (amount > 100000) {
            throw new IllegalArgumentException(ValidateMessage.NOT_PURCHASE_MORE_HUNDRED_THOUSAND.getMessage());
        }
    }
}
