package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class Statistics {

    private final Map<Rank, Integer> rankCountMap = new EnumMap<>(Rank.class);

    public Statistics() {
        for (Rank rank : Rank.values()) {
            rankCountMap.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        rankCountMap.put(rank, rankCountMap.get(rank) + 1);
    }

    public Map<Rank, Integer> getRankCountMap() {
        return rankCountMap;
    }

    public double calculateYield(long totalPrize, long totalInvestment) {
        if (totalInvestment == 0) {
            return 0;
        }
        return (double) totalPrize / totalInvestment * 100;
    }
}
