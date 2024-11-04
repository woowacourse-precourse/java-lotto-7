package lotto.domain;

import java.util.List;

public class LottoResult {
    private final WinningStatistics statistics;
    private final PurchaseAmount purchaseAmount;

    private LottoResult(WinningStatistics statistics, PurchaseAmount purchaseAmount) {
        this.statistics = statistics;
        this.purchaseAmount = purchaseAmount;
    }

    public static LottoResult of(List<Lotto> lottos, WinningNumbers winningNumbers, PurchaseAmount purchaseAmount) {
        WinningStatistics statistics = WinningStatistics.from(lottos, winningNumbers);
        return new LottoResult(statistics, purchaseAmount);
    }

    public int getCountByRank(LottoRank rank) {
        return statistics.getCountByRank(rank);
    }

    public double calculateProfitRate() {
        long totalPrize = statistics.calculateTotalPrize();
        return (totalPrize * 100.0) / purchaseAmount.getAmount();
    }
}