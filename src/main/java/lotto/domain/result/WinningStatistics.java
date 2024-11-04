package lotto.domain.result;

import lotto.domain.money.Money;
import java.util.Map;
import java.util.EnumMap;
import java.util.Collections;

public class WinningStatistics {
    private final Map<LottoRank, Integer> rankCounts;

    private WinningStatistics(Map<LottoRank, Integer> rankCounts) {
        this.rankCounts = new EnumMap<>(rankCounts);
    }

    public static WinningStatistics from(Map<LottoRank, Integer> rankCounts) {
        return new WinningStatistics(rankCounts);
    }

    public Money calculateTotalPrize() {
        int totalAmount = 0;
        for (Map.Entry<LottoRank, Integer> entry : rankCounts.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            totalAmount += rank.getPrizeMoney().getAmount() * count;
        }
        return Money.from(totalAmount);
    }

    public int getWinningCount(LottoRank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return Collections.unmodifiableMap(rankCounts);
    }
}