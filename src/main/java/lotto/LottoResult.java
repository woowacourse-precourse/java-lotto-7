package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCountMap = new EnumMap<>(LottoRank.class);
    private int totalTickets = 0;

    public LottoResult() {
        for (LottoRank rank : LottoRank.values()) {
            rankCountMap.put(rank, 0);
        }
    }

    public void addResult(int matchCount, boolean bonusMatch) {
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
        rankCountMap.put(rank, rankCountMap.get(rank) + 1);
        totalTickets++;
    }

    public int getCountForRank(LottoRank rank) {
        return rankCountMap.get(rank);
    }

    public double calculateProfitRate() {
        long totalPrize = rankCountMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        long totalCost = totalTickets * 1000L;
        return (double) totalPrize / totalCost * 100;
    }
}
