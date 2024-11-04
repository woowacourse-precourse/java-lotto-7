package lotto.domain;

import lotto.domain.validator.ParamsValidator;
import lotto.exception.money.MoneyAmountOutOfRangeException;
import lotto.exception.money.MoneyUnitInvalidException;

final public class Money {

    private static final int MIN_MONEY = 1000;
    private static final int MAX_MONEY = 100000;
    private static final int MONEY_UNIT = 1000;

    private final int amount;

    private Money(int amount) {
        validateMoneyInRange(amount);
        validateMoneyUnit(amount);
        this.amount = amount;
    }

    private static void validateMoneyInRange(int amount) {
        if (amount < MIN_MONEY || MAX_MONEY < amount) {
            throw new MoneyAmountOutOfRangeException(MIN_MONEY, MAX_MONEY);
        }
    }

    private static void validateMoneyUnit(int amount) {
        if (amount % MONEY_UNIT != 0) {
            throw new MoneyUnitInvalidException(MONEY_UNIT);
        }
    }

    public static Money from(Integer amount) {
        ParamsValidator.validateParamsNotNull(Money.class, amount);

        return new Money(amount);
    }

    public int getAmount() {
        return amount;
    }
}
