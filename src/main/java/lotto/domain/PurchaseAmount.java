package lotto.domain;

import lotto.util.Convertor;
import lotto.validation.PurchaseAmountValidator;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1000;

    private final long purchaseAmount;

    private PurchaseAmount(long purchaseAmount) {
        PurchaseAmountValidator.validateDivisibleByThousand(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(String input) {
        long amount = Convertor.convertToLong(input);
        return new PurchaseAmount(amount);
    }

    public int countLottoQuantity() {
        return (int) purchaseAmount / LOTTO_PRICE;
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }
}

