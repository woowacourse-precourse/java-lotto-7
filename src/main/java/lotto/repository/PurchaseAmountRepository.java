package lotto.repository;

import lotto.domain.PurchaseAmount;

public class PurchaseAmountRepository {
    private static final PurchaseAmountRepository PURCHASE_AMOUNT_REPOSITORY = new PurchaseAmountRepository();

    private int value;

    private PurchaseAmountRepository() {

    }

    public static PurchaseAmountRepository getInstance() {
        return PURCHASE_AMOUNT_REPOSITORY;
    }

    public void save(final int value) {
        this.value = value;
    }

    public PurchaseAmount find() {
        return new PurchaseAmount(value);
    }
}
