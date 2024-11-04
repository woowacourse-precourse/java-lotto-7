package lotto.domain;

import java.util.List;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCount;
    private final int totalPurchaseAmount;

    private LottoResult(Map<Rank, Integer> rankCount, int totalPurchaseAmount) {
        this.rankCount = rankCount;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public static LottoResult of(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> rankCount = initializeRankCount();

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            rankCount.merge(rank, 1, Integer::sum);
        }

        return new LottoResult(rankCount, lottos.size() * 1000);
    }

    private static Map<Rank, Integer> initializeRankCount() {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
        return rankCount;
    }

    public double calculateProfitRate() {
        long totalPrize = calculateTotalPrize();
        return (totalPrize * 100.0) / totalPurchaseAmount;
    }

    private long calculateTotalPrize() {
        return rankCount.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Map<Rank, Integer> getRankCount() {
        return new EnumMap<>(rankCount);
    }
}