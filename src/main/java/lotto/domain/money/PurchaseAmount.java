package lotto.domain.money;

import lotto.exception.LottoApplicationException;

public class PurchaseAmount {

    private static final int UNIT = 1000;
    private static final int MIN_AMOUNT = 0;

    private final int amount;

    private PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static PurchaseAmount from(int amount) {
        return new PurchaseAmount(amount);
    }

    private void validate(int amount) {
        if (amount < MIN_AMOUNT) {
            throw new LottoApplicationException(String.format("구입 금액은 %,d보다 작을 수 없습니다.", MIN_AMOUNT));
        }
        if (amount % UNIT != 0) {
            throw new LottoApplicationException(String.format("구입 금액은 %,d원 단위여야 합니다.", UNIT));
        }
    }

    public Money toMoney() {
        return new Money(amount);
    }

}
