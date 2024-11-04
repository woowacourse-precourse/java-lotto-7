package lotto.model;

import lotto.enumerate.ExceptionEnum;
import lotto.utility.ExceptionThrower;

public class PurchaseCost {
    private static final int MIN_PURCHASE_COST = 0;
    private static final int DIVISOR = 1000;
    private int purchaseCost;

    public PurchaseCost(int inputtedCost) {
        validateUnderZero(inputtedCost);
        validateCanDivideBy1000(inputtedCost);
        this.purchaseCost = inputtedCost;
    }

    private void validateUnderZero(int inputtedCost) {
        if (inputtedCost < MIN_PURCHASE_COST) {
            ExceptionThrower.throwing(ExceptionEnum.CANNOT_UNDER_ZERO);
        }
    }

    private void validateCanDivideBy1000(int inputtedCost) {
        if (inputtedCost % DIVISOR != 0) {
            ExceptionThrower.throwing(ExceptionEnum.UNDIVIDABLE_BY_THOUSAND);
        }
    }

    public int calculateBuyableLottoCount() {
        return this.purchaseCost / DIVISOR;
    }

    public int getPurchaseCost() {
        return this.purchaseCost;
    }
}
