package lotto.money.infrastructure;

import lotto.money.domain.Money;
import lotto.money.service.LottoPurchaseCalculator;

public class DivideThousandCalculator implements LottoPurchaseCalculator {
    private final Long PRICE_PER_LOTTO = 1000L;
    @Override
    public int calculate(Money money) {
        return (int) (money.getMoney() / PRICE_PER_LOTTO);
    }
}
