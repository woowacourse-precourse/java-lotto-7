package lotto;

import static lotto.constant.ErrorMessage.LESS_THAN_THOUSAND_PURCHASE_AMOUNT;
import static lotto.constant.ErrorMessage.NOT_PURCHASE_AMOUNT_FORMAT;

public class PurchaseAmount {
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final int PURCHASE_AMOUNT_REMAIN = 0;
    private final int purchasePrice;

    public PurchaseAmount(int purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validatePurchasePrice(int purchasePrice) {
        isPurchaseAmountLessThanThousand(purchasePrice);
        isPurchaseAmountMultipleOfThousand(purchasePrice);
    }

    public int getPurchaseAmount() {
        return purchasePrice / PURCHASE_AMOUNT_UNIT;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    private void isPurchaseAmountLessThanThousand(int purchasePrice) {
        if (purchasePrice < PURCHASE_AMOUNT_UNIT) {
            throw new IllegalArgumentException(LESS_THAN_THOUSAND_PURCHASE_AMOUNT.getMessage());
        }
    }

    private void isPurchaseAmountMultipleOfThousand(int purchasePrice) {
        if (purchasePrice % PURCHASE_AMOUNT_UNIT != PURCHASE_AMOUNT_REMAIN) {
            throw new IllegalArgumentException(NOT_PURCHASE_AMOUNT_FORMAT.getMessage());
        }
    }
}
