package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> rankCounts = new HashMap<>();

    public void addResult(int matchCount, boolean bonusMatch) {
        int rank = getRank(matchCount, bonusMatch);
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
    }

    private int getRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return 1;
        if (matchCount == 5 && bonusMatch) return 2;
        if (matchCount == 5) return 3;
        if (matchCount == 4) return 4;
        if (matchCount == 3) return 5;
        return 0;
    }

    public Map<Integer, Integer> getRankCounts() {
        return rankCounts;
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalPrize = rankCounts.getOrDefault(1, 0) * 2000000000 +
                rankCounts.getOrDefault(2, 0) * 30000000 +
                rankCounts.getOrDefault(3, 0) * 1500000 +
                rankCounts.getOrDefault(4, 0) * 50000 +
                rankCounts.getOrDefault(5, 0) * 5000;
        return ((double) totalPrize / purchaseAmount) * 100;
    }
}
