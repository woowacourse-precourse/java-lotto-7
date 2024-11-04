package lotto.model;

import static lotto.common.constant.LottoIntegerConstant.LOTTO_PRICE;
import static lotto.common.exception.ErrorMessage.PURCHASE_AMOUNT_VALUE_ERROR;

public class PurchaseAmount {

    private final int amount;

    private PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static PurchaseAmount from(int amount) {
        return new PurchaseAmount(amount);
    }

    public int getPurchaseQuantity() {
        return amount / LOTTO_PRICE.number();
    }

    public int amount() {
        return amount;
    }

    private void validate(int amount) {
        if (amount % LOTTO_PRICE.number() != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_VALUE_ERROR.message());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseAmount that = (PurchaseAmount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(amount);
    }
}
