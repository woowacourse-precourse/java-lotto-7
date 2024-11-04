package lotto.function.purchase.processor;

import lotto.util.calculator.PurchasableCalculator;
import lotto.value.LottoValue;

public class PurchasableCountCalculateProcessor {

    private final PurchasableCalculator purchasableCalculator;

    public PurchasableCountCalculateProcessor(PurchasableCalculator purchasableCalculator) {
        this.purchasableCalculator = purchasableCalculator;
    }

    public int calculatePurchasableCount(int purchaseAmount) {
        return purchasableCalculator.calculatePurchasableCount(
                purchaseAmount, LottoValue.PRICE.value());
    }

}
