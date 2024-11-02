package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private static final int PERCENTAGE_MULTIPLIER = 100;
    private final Map<LottoRank, Integer> rankCounts;
    private final int purchaseAmount;

    public LottoResult(int purchaseAmount) {
        this.rankCounts = new EnumMap<>(LottoRank.class);
        this.purchaseAmount = purchaseAmount;
        initializeResult();
    }

    private void initializeResult() {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addWinningResult(Lotto userLotto, WinningLotto winningLotto) {
        int matchCount = winningLotto.matchNumbers(userLotto);
        boolean hasBonus = matchCount == 5 && winningLotto.matchBonus(userLotto);

        LottoRank rank = LottoRank.valueOf(matchCount, hasBonus);
        updateRankCount(rank);
    }

    private void updateRankCount(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    private long calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToLong(this::calculatePrizeForRank)
                .sum();
    }

    private long calculatePrizeForRank(Map.Entry<LottoRank, Integer> entry) {
        return (long) entry.getKey().getAmount() * entry.getValue();
    }

    public double calculateProfitRate() {
        long totalPrize = calculateTotalPrize();
        return (totalPrize * PERCENTAGE_MULTIPLIER) / (double) purchaseAmount;
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return Collections.unmodifiableMap(rankCounts);
    }
}