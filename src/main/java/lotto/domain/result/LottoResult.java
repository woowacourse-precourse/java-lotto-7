package lotto.domain.result;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.PurchaseAmount;
import lotto.domain.number.WinningNumbers;

public class LottoResult {
    private static final double PERCENTAGE_MULTIPLIER = 100.0;

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
        return (totalPrize * PERCENTAGE_MULTIPLIER) / purchaseAmount.getAmount();
    }
}