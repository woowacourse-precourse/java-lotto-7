package lotto.domain.calculator;

import lotto.domain.money.Money;
import lotto.domain.result.WinningResult;
import lotto.domain.result.WinningStatistics;

public class ProfitCalculator {
    public WinningResult calculateResult(WinningStatistics statistics, Money purchaseMoney) {
        return WinningResult.of(statistics, purchaseMoney);
    }
}