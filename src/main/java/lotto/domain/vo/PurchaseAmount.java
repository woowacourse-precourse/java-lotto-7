package lotto.domain.vo;

import static lotto.domain.constants.LottoConstants.LOTTO_PRICE;
import static lotto.exception.ErrorMessage.*;

public class PurchaseAmount {
    private final Integer amount;

    private PurchaseAmount(Integer amount) {
        this.amount = amount;
    }

    public static PurchaseAmount of(Integer amount) {
        validate(amount);
        return new PurchaseAmount(amount);
    }

    private static void validate(Integer amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(MONEY_INSUFFICIENT.getLottoPriceIncludeMessage());
        }
        if (isMoneyLeft(amount)) {
            throw new IllegalArgumentException(MONEY_LEFT.getLottoPriceIncludeMessage());
        }
    }

    private static boolean isMoneyLeft(Integer amount) {
        return (amount % LOTTO_PRICE) != 0;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer calculateLottoCount() {
        return amount / LOTTO_PRICE;
    }
}
