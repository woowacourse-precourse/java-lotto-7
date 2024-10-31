package lotto.amount;

import lotto.exception.CustomException;
import lotto.exception.ExceptionMessage;

public class Amount {

    private static final int LOTTO_PURCHASE_UNIT = 1_000;

    private final int value;

    public Amount(int value) {
        validatePurchaseUnit(value);
        this.value = value;
    }

    private void validatePurchaseUnit(int amount) {
        if (isNotDivisibleByLottoPurchaseUnit(amount)) {
            throw new CustomException(ExceptionMessage.INVALID_LOTTO_AMOUNT_EXCEPTION);
        }
    }

    private boolean isNotDivisibleByLottoPurchaseUnit(int amount) {
        return amount % LOTTO_PURCHASE_UNIT != 0;
    }
}
