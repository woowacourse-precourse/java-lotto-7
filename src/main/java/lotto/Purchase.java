package lotto;

import lotto.constant.ErrorMessage;

import static lotto.constant.PurchaseConfig.*;

public class Purchase {
    private final int price;

    public Purchase(int price) {
        validatePurchaseRange(price);
        validatePurchaseUnit(price);
        this.price = price;
    }

    private void validatePurchaseRange(int price) {
        if (price < MIN_PURCHASE || price > MAX_PURCHASE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_RANGE.getMessage());
        }
    }

    private void validatePurchaseUnit(int price) {
        if (price % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_UNIT.getMessage());
        }
    }

    public int getPrice() {
        return price;
    }
}
