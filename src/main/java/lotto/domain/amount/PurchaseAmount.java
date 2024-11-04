package lotto.domain.amount;

import static lotto.infrastructure.exception.ErrorCode.*;

public class PurchaseAmount extends Amount {

    private final int MINIMUM_AMOUNT_CRITERION = 1000;

    public PurchaseAmount(int amount) {
        super(amount);
        validate(amount);
    }

    private void validate(int amount) {
        validateDividedByProperUnit(amount);
        validateProperAmount(amount);
    }

    private void validateProperAmount(int amount) {
        if (amount < MINIMUM_AMOUNT_CRITERION) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateDividedByProperUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
