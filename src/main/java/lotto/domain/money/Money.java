package lotto.domain.money;

import lotto.global.exception.Exception;
import lotto.global.exception.ValidatorBuilder;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    private Money(final String money) {
        this.money = validateMoney(money);
    }

    public static Money from(final String money) {
        return new Money(money);
    }

    private int validateMoney(final String inputMoney) {
        return ValidatorBuilder.from(inputMoney)
                .validateIsInteger()
                .validateInteger(money -> money < LOTTO_PRICE, Exception.INVALID_MONEY_FORMAT)
                .validateInteger(money -> money % LOTTO_PRICE != 0, Exception.INDIVISIBLE_MONEY)
                .getNumericValue();
    }

}

