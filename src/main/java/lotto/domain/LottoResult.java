package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts;
    private final int totalPurchaseAmount;

    private LottoResult(Map<LottoRank, Integer> rankCounts, int totalPurchaseAmount) {
        this.rankCounts = new EnumMap<>(rankCounts);
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public static LottoResult of(List<Lotto> lottos, WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        initializeRankCounts(rankCounts);

        for (Lotto lotto : lottos) {
            LottoRank rank = LottoRank.valueOf(lotto.countMatchNumbers(winningNumbers.getWinningNumbers()),
                    lotto.matchBonusNumber(winningNumbers.getBonusNumber()));
            rankCounts.merge(rank, 1, Integer::sum);
        }

        return new LottoResult(rankCounts, lottos.size() * 1000);
    }

    private static void initializeRankCounts(Map<LottoRank, Integer> rankCounts) {
        Arrays.stream(LottoRank.values())
                .forEach(rank -> rankCounts.put(rank, 0));
    }

    public int getCountByRank(LottoRank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public double calculateProfitRate() {
        long totalPrize = calculateTotalPrize();
        return (totalPrize * 100.0) / totalPurchaseAmount;
    }

    private long calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}