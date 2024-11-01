package lotto;

import constants.ErrorMessage;
import java.util.Objects;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1_000;

    private final int money;

    public PurchaseAmount(int money) {
        checkDivided(money);
        this.money = money;
    }

    private void checkDivided(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.UNDIVIDED_THOUSAND);
        }
    }

    public int divideLottoPrice() {
        return money / LOTTO_PRICE;
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
