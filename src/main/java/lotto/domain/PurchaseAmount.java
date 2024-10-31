package lotto.domain;

import lotto.util.Convertor;

public class PurchaseAmount {

    private final int LOTTO_PRICE = 1000;

    private final long purchaseAmount;

    private PurchaseAmount(long purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(String input) {
        long amount = Convertor.convertToLong(input);
        return new PurchaseAmount(amount);
    }
}
