package lotto.model;

import lotto.constant.ErrorMessage;

import static lotto.constant.PurchaseConfig.MAX_PURCHASE;
import static lotto.constant.PurchaseConfig.MIN_PURCHASE;
import static lotto.constant.PurchaseConfig.PURCHASE_UNIT;

public class Purchase {
    private final int cost;

    public Purchase(int cost) {
        validatePurchaseRange(cost);
        validatePurchaseUnit(cost);
        this.cost = cost;
    }

    private void validatePurchaseRange(int cost) {
        if (cost < MIN_PURCHASE || cost > MAX_PURCHASE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_RANGE.getMessage());
        }
    }

    private void validatePurchaseUnit(int cost) {
        if (cost % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_UNIT.getMessage());
        }
    }

    public int getCost() {
        return cost;
    }
}
