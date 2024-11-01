package lotto.calculator.infrastructure;

import lotto.money.domain.Money;
import lotto.calculator.domain.Calculator;

public class DivideThousandCalculator implements Calculator {
    private final Long PRICE_PER_LOTTO = 1000L;
    @Override
    public int calculate(Money money) {
        return (int) (money.getMoney() / PRICE_PER_LOTTO);
    }
}
