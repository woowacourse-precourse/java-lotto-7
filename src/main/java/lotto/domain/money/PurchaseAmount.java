package lotto.domain.money;

import lotto.exception.LottoApplicationException;

public class PurchaseAmount {

    private static final int UNIT = 1000;
    private static final int MIN_AMOUNT = 1000;
    private static final int MAX_AMOUNT = 100_000;

    private final int amount;

    private PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static PurchaseAmount from(int amount) {
        return new PurchaseAmount(amount);
    }

    private void validate(int amount) {
        if (isOutOfRange(amount)) {
            String message = String.format("구입 금액은 %,d원 이상, %,d원 이하여야 합니다.", MIN_AMOUNT, MAX_AMOUNT);
            throw new LottoApplicationException(message);
        }
        if (isInvalidUnit(amount)) {
            throw new LottoApplicationException(String.format("구입 금액은 %,d원 단위여야 합니다.", UNIT));
        }
    }

    private boolean isOutOfRange(int amount) {
        return amount < MIN_AMOUNT || amount > MAX_AMOUNT;
    }

    private boolean isInvalidUnit(int amount) {
        return amount % UNIT != 0;
    }

    public Money toMoney() {
        return new Money(amount);
    }

}
