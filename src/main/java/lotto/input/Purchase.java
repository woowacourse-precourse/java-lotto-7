package lotto.input;

import static lotto.constants.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR;

public class Purchase {

    private final int purchase;

    public Purchase(int purchase) {
        isDivisibleByThousand(purchase);
        this.purchase = purchase;
    }

    private void isDivisibleByThousand(int purchase) {
        if (purchase % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR.getMessage());
        }
    }
}
