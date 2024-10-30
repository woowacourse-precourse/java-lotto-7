package lotto.input;

import static lotto.constants.ErrorMessage.INPUT_MUST_BE_NUMBER;
import static lotto.constants.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR;

public class Purchase {

    private final int purchase;

    public Purchase(int purchase) {
        isDivisibleByThousand(purchase);
        this.purchase = purchase;
    }

    public int getPurchase() {
        return purchase;
    }

    private void isDivisibleByThousand(int purchase) {
        if (purchase % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR.getMessage());
        }
    }

    private void isPositiveAmount(int purchase) {
        if (purchase <= 0) {
            throw new IllegalArgumentException(INPUT_MUST_BE_NUMBER.getMessage());
        }
    }
}
