package lotto.domain.result;

import lotto.domain.money.Money;

public class WinningResult {
    private final WinningStatistics statistics;
    private final Money purchaseMoney;

    private WinningResult(WinningStatistics statistics, Money purchaseMoney) {
        this.statistics = statistics;
        this.purchaseMoney = purchaseMoney;
    }

    public static WinningResult of(WinningStatistics statistics, Money purchaseMoney) {
        return new WinningResult(statistics, purchaseMoney);
    }

    public double calculateProfitRate() {
        Money totalPrize = statistics.calculateTotalPrize();
        return purchaseMoney.calculateProfitRate(totalPrize);
    }

    public int getWinningCount(LottoRank rank) {
        return statistics.getWinningCount(rank);
    }

    public WinningStatistics getStatistics() {
        return statistics;
    }
}