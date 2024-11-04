package lotto.domain.calculator;

import lotto.domain.money.Money;
import lotto.domain.result.WinningResult;
import lotto.domain.result.WinningStatistics;

public class ProfitCalculator {
    public WinningResult calculateResult(WinningStatistics statistics, Money purchaseMoney) {
        Money totalPrize = statistics.calculateTotalPrize();
        double profitRate = calculateProfitRate(purchaseMoney, totalPrize);
        return createWinningResult(statistics, profitRate);
    }

    private double calculateProfitRate(Money purchaseMoney, Money totalPrize) {
        return purchaseMoney.calculateProfitRate(totalPrize);
    }

    private WinningResult createWinningResult(WinningStatistics statistics, double profitRate) {
        return WinningResult.of(statistics, profitRate);
    }
}