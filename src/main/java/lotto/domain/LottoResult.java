package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> rankCounts;

    public LottoResult() {
        this.rankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public int getCountForRank(Rank rank) {
        return rankCounts.get(rank);
    }

    public long calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

}