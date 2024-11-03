package lotto.domain.money;

import static lotto.ErrorCode.*;

public class PurchaseAmount extends Money {

    public PurchaseAmount(String amount) {
        super(amount);
        validate(amount);
    }

    private void validate(String amount) {
        if (Integer.parseInt(amount) % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
