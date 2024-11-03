package lotto.domain.vo;

import lotto.exception.ErrorMessage;

public class PurchaseAmount {
    private static final Integer LOTTO_PRICE = 1000;

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
            throw new IllegalArgumentException(ErrorMessage.MONEY_INSUFFICIENT.getFormattedMessage(LOTTO_PRICE));
        }
        if (isMoneyLeft(amount)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_LEFT.getFormattedMessage(LOTTO_PRICE));
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
