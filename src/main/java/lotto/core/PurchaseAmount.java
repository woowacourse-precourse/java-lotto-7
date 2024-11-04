package lotto.core;

import constants.ErrorMessage;
import java.util.Objects;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1_000;

    private final int money;

    public PurchaseAmount(String input) {
        int money = toInt(input);
        checkDivided(money);
        this.money = money;
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT);
        }
    }

    private void checkDivided(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.UNDIVIDED_THOUSAND);
        }
    }

    public int calculatePurchaseCount() {
        return money / LOTTO_PRICE;
    }

    public double revenueRatio(int totalRevenue) {
        return (double) totalRevenue / money;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PurchaseAmount purchaseAmount)) {
            return false;
        }
        return money == purchaseAmount.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
