package lotto.domain.amount;

import static lotto.ErrorCode.*;

public class PurchaseAmount extends Amount {

    public PurchaseAmount(int amount) {
        super(amount);
        validate(amount);
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
