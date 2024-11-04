package lotto.fixture;

import lotto.model.money.Money;

public class MoneyFixture {

    private MoneyFixture() {
    }

    public static Money create(long value) {
        return Money.of(value);
    }
}
