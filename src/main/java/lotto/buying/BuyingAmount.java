package lotto.buying;

import java.util.Objects;

public class BuyingAmount {
    public static final int LOTTO_AMOUNT_UNIT = 1000;
    public static final int MINIMUM_LOTTO_AMOUNT = 1000;
    public static final int MAXIMUM_LOTTO_AMOUNT = 100000;

    private final int buyingAmount;

    private BuyingAmount(int buyingAmount) {
        validateLessThanMinimumAmount(buyingAmount);
        validateNotAmountUnit(buyingAmount);
        validateMoreThanMaximumAmount(buyingAmount);
        this.buyingAmount = buyingAmount;
    }

    public static BuyingAmount from(int buyingAmount) {
        return new BuyingAmount(buyingAmount);
    }

    private void validateLessThanMinimumAmount(int buyingNumber) {
        if (buyingNumber < MINIMUM_LOTTO_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 천원 미만입니다.");
        }
    }

    private void validateNotAmountUnit(int buyingAmount) {
        if (Math.floorMod(buyingAmount, LOTTO_AMOUNT_UNIT) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 천원 단위여야 합니다.");
        }
    }

    private void validateMoreThanMaximumAmount(int buyingAmount) {
        if (buyingAmount > MAXIMUM_LOTTO_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 구입은 한 번에 10만원까지만 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BuyingAmount that)) {
            return false;
        }
        return buyingAmount == that.buyingAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(buyingAmount);
    }
}
