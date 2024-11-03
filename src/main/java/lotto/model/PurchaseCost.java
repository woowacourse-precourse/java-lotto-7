package lotto.model;

import lotto.utility.ExceptionEnum;

public class PurchaseCost {
    private int purchaseCost;

    public PurchaseCost(int inputtedCost) {
        validateUnderZero(inputtedCost);
        validateCanDivideBy1000(inputtedCost);
        this.purchaseCost = inputtedCost;
    }

    private void validateUnderZero(int inputtedCost) {
        if (inputtedCost <= 0) {
            throw new IllegalArgumentException(ExceptionEnum.CANNOT_UNDER_ZERO.getMessage());
        }
    }

    private void validateCanDivideBy1000(int inputtedCost) {
        if (inputtedCost % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionEnum.UNDIVIDABLE_BY_THOUSAND.getMessage());
        }
    }

    public int calculateBuyableLottoCount() {
        return this.purchaseCost / 1000;
    }
}
