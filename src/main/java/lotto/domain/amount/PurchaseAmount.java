package lotto.domain.amount;

import static lotto.infrastructure.exception.ErrorCode.*;

public class PurchaseAmount extends Amount {

    private PurchaseAmount(int amount) {
        super(amount);
        validate(amount);
    }

    public static PurchaseAmount from(final String value) {
        return new PurchaseAmount(Integer.parseInt(value));
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
