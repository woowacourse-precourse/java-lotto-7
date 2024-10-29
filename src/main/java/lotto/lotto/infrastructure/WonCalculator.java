package lotto.lotto.infrastructure;

import lotto.buyer.domain.Money;
import lotto.lotto.domain.Calculator;

public class WonCalculator implements Calculator {
    private final Long PRICE_PER_LOTTO = 1000L;
    @Override
    public int divideByThousand(Money money) {
        return (int) (money.getMoney() / PRICE_PER_LOTTO);
    }
}
