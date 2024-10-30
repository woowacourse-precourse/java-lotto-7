package lotto.helper;

import lotto.model.money.Money;

public class MoneyHelper {

    public static Money mock(long amount) {
        return Money.from(amount);
    }

}
