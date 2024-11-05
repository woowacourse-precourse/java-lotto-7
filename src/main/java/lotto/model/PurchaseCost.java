package lotto.model;

import lotto.constants.Constants;
import lotto.enumerate.ExceptionEnum;
import lotto.utility.ExceptionThrower;

public class PurchaseCost {
    private int purchaseCost;

    public PurchaseCost(int inputtedCost) {
        validateUnderZero(inputtedCost);
        validateCanDivideBy1000(inputtedCost);
        this.purchaseCost = inputtedCost;
    }

    private void validateUnderZero(int inputtedCost) {
        if (inputtedCost < Constants.MIN_PURCHASE_COST) {
            ExceptionThrower.throwing(ExceptionEnum.CANNOT_UNDER_ZERO);
        }
    }

    private void validateCanDivideBy1000(int inputtedCost) {
        if (inputtedCost % Constants.DIVISOR != 0) {
            ExceptionThrower.throwing(ExceptionEnum.UNDIVIDABLE_BY_THOUSAND);
        }
    }

    public int calculateBuyableLottoCount() {
        return this.purchaseCost / Constants.DIVISOR;
    }

    public int getPurchaseCost() {
        return this.purchaseCost;
    }
}
